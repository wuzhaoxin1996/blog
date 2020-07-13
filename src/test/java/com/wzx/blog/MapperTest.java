package com.wzx.blog;

import com.wzx.blog.dao.NotePostMapper;
import com.wzx.blog.dao.UserMapper;
import com.wzx.blog.entity.NotePost;
import com.wzx.blog.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = BlogApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NotePostMapper notePostMapper;
    @Test
    public void testSelectUser(){
        User user =  userMapper.selectById(150);
        System.out.println(user);

        user =  userMapper.selectByName("test");
        System.out.println(user);

        user =  userMapper.selectByEmail("test@qq.com");
        System.out.println(user);
    }

    @Test
    public  void  testInsertUser(){
        User user = new User();
        user.setUsername("test1");
        user.setPassword("1234561");
        user.setSalt("abc1");
        user.setEmail("test1@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/102.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.nowcoder.com/104.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150,"hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPost(){
        List<NotePost> list = notePostMapper.selectNotePosts(0,0,10);
        for(NotePost post : list){
            System.out.println(post);
        }

        int rows = notePostMapper.selectNotePostRows(151);
        System.out.println(rows);
    }
}
