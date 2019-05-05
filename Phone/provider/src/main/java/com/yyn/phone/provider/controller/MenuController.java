package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.Menu;
import com.yyn.phone.provider.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menuList")
//    public List<Menu> showAllMenus(){
//        return menuService.showAllMenus();
//    }
    public List<Menu> showMenuByIds(Integer id){
        return menuService.showMenuByIds(id);
    }

}
