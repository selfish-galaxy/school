package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class MenuController {

    @Resource
    private MenuService menuService;

    @RequestMapping("/menuList")
    public String menuList(Model model, Integer id, HttpSession session){
//        model.addAttribute("menus",menuService.showMenusByIds(id));
        session.setAttribute("menus",menuService.showMenusByIds(id));
        return "seller/index";
    }
}
