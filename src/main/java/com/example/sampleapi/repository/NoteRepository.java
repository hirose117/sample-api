package com.example.sampleapi.repository;

import com.example.sampleapi.dto.Note;
import com.example.sampleapi.exception.NoteNotFoundException;
import com.example.sampleapi.mapper.NoteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository {
    private final NoteMapper noteMapper;

    public NoteRepository(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    // 全件表示
    public List<Note> findAll(){
        return noteMapper.findAll();
    }

    // 入力
    public int insert(Note note){
        return noteMapper.insert(note);
    }

    // 1件取得
    public Note findById(long id){
        return  noteMapper.findById(id);
    }

    // 削除
    public boolean delete(long id){
        return noteMapper.delete(id) == 1;
    }

    // 更新
    public Note update(Note note){
        if(noteMapper.update(note) == 0){
            throw new NoteNotFoundException(note.getId());
        }
        return note;
    }
}
