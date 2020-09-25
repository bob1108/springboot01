package com.ycu.lgw.controller;

import com.ycu.lgw.model.User;
import com.ycu.lgw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }
    
    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = this.userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * 跳转增加用户页面
     * @return
     */
    @RequestMapping("/toAdd")
    public  String toAdd(){
        return "user/userAdd";
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String add(User user){
        userService.save(user);
        return "redirect:/list";
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Long id) {
        this.userService.delete(id);
        return "redirect:/list";
    }

    /**
     *
     * 跳转编辑页面
     */

    @RequestMapping("/toEdit")
    public  String toEdit(Model model,int id){
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }


    @RequestMapping("/edit")
    public  String edit(User user){
        userService.edit(user);
        return "redirect:/list";
    }






}