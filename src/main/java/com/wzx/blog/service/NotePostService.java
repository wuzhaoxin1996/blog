package com.wzx.blog.service;

import com.wzx.blog.dao.NotePostMapper;
import com.wzx.blog.entity.NotePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotePostService {

    @Autowired
    private NotePostMapper notePostMapper;

    public List<NotePost> findNotePosts(int userId, int offset, int limit){
        return notePostMapper.selectNotePosts(userId,offset,limit);
    }

    public int findNotePostRows(int userId){
        return notePostMapper.selectNotePostRows(userId);
    }
}
