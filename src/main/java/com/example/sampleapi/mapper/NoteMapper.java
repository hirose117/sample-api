package com.example.sampleapi.mapper;

import com.example.sampleapi.dto.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    // データを降順(新しい)にソート
    // 全件取得
    @Select("SELECT id, title, content, created_at FROM notes ORDER BY created_at DESC")
    List<Note> findAll();

    // id、タイムスタンプ、id（createdAt）以外を入力
    @Insert("INSERT INTO notes (title, content) VALUES (#{title}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id,createdAt", keyColumn = "id,created_at")
    int insert(Note note);

    // 1件のみ取得
    @Select("SELECT id, title, content, created_at FROM notes WHERE id = #{id} ")
    Note findById(long id);

    // 1件、指定して削除
    @Delete("DELETE FROM notes WHERE id = #{id}")
    int delete(long id);

    // 1件更新
    @Update("UPDATE notes SET title = #{title}, content = #{content} WHERE id = #{id}")
    int update(Note note);
}
