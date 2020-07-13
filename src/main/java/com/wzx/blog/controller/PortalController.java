package com.wzx.blog.controller;

import com.wzx.blog.entity.NotePost;
import com.wzx.blog.entity.Page;
import com.wzx.blog.entity.User;
import com.wzx.blog.service.NotePostService;
import com.wzx.blog.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PortalController {

    @Autowired
    private NotePostService notePostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/portal", method = RequestMethod.GET)
    public String getPatrol(Model model, Page page){
        page.setRows(notePostService.findNotePostRows(0));
        page.setPath("/portal");

        List<NotePost> list = notePostService.findNotePosts(0,page.getOffser(),page.getLimit());
        List<Map<String, Object>> notePosts = new ArrayList<>();
        if(list != null){
            for(NotePost post : list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                notePosts.add(map);
            }
        }
        model.addAttribute("notePosts",notePosts);
        return "/portal.html";
    }
}
