package com.example.sampleapi.service;

import com.example.sampleapi.dto.Note;
import com.example.sampleapi.exception.NoteArgumentNotValidException;
import com.example.sampleapi.exception.NoteNotFoundException;
import com.example.sampleapi.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {


    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    // データを保存
    public Note saveNote (Note note) {
        // titleが空の場合のバリデーション
        if(note.getTitle() == null || note.getTitle().isEmpty()){
            throw new NoteArgumentNotValidException("title is empty");
        }

        // contentが空の場合のバリデーション
        if(note.getContent() == null || note.getContent().isEmpty()){
            throw new NoteArgumentNotValidException("content is empty");
        }

        noteRepository.insert(note);
        return note;
    }

    // 1件取得
    public Note findById(long id) {
        Note note = noteRepository.findById(id);
        // idがない場合の処理
        if (note == null){
            throw new NoteNotFoundException(id);
        }
        return note;
    }

    // 削除
    public boolean delete(long id) {
        // 削除するidがない場合の処理
        if(!noteRepository.delete(id)){
            throw new NoteNotFoundException(id);
        }
        return true;
    }

    // 更新の処理
    @Transactional
    public Note update(Note note, long id) {
        // titleが空の場合のバリデーション
        if(note.getTitle() == null || note.getTitle().isEmpty()){
            throw new NoteArgumentNotValidException("title is empty");
        }

        // contentが空の場合のバリデーション
        if(note.getContent() == null || note.getContent().isEmpty()){
            throw new NoteArgumentNotValidException("content is empty");
        }

        // 指定されたIDが存在しない場合のバリデーション
        Note targetNote = noteRepository.findById(id);
        if (targetNote == null){
            throw new NoteNotFoundException(id);
        }

        // IDや作成日時を正しくセットしてデータベースを更新する処理
        note.setId(id);
        note.setCreatedAt(targetNote.getCreatedAt());
        return noteRepository.update(note);
    }
}
