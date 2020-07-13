package com.wzx.blog.dao;

import com.wzx.blog.entity.NotePost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotePostMapper {

    List<NotePost> selectNotePosts(int userId, int offset, int limit);

    // @Paramy注解用于给参数取别名
    // 如果只有一个参数，且在<if>里面使用，必须要进行注解
    int selectNotePostRows(@Param("userId") int userId);

}
