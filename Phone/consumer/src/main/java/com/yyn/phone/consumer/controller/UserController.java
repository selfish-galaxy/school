package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.UserService;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
    查询所有，显示列表
     */
    @RequestMapping("/userList1")
    public String userList1(Model model){
        model.addAttribute("users",userService.showAllUsers());
        return "seller/user";
    }

    /*
    去添加页
     */
    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        return "seller/userAdd";
    }

    /*
    添加
     */
    @RequestMapping("addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:userList";
    }

    /*
   删除(真删除)
    */
    @RequestMapping("/delUser")
    public String delUser(Integer id){
        userService.delUser(id);
        return "redirect:userList";
    }

    /*
    去修改页
     */
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Integer id,Model model){
        model.addAttribute("user",userService.selectOneUser(id));
        return "seller/userUpdate";
    }

    /*
    修改
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:userList";
    }

    /*
    查询所有，显示列表（带分页）
     */
    @RequestMapping("/userList")
    public String userList(Integer currentPage, Integer size, Model model){
        if(currentPage == null){
            currentPage = 1;
        }
        if(size == null){
            size = 10;
        }
        StringBuilder params = new StringBuilder();
        params.append("size=" + size);
        PageBean<User> userPageBean = userService.userPage(currentPage, size);
        userPageBean.pageView("userList", params.toString());
        model.addAttribute("users",userPageBean);
        return "seller/user";
    }
}
