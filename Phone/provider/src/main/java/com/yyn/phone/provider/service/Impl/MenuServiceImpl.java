package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.MenuRepository;
import com.yyn.phone.provider.dao.RoleRepository;
import com.yyn.phone.provider.pojo.Menu;
import com.yyn.phone.provider.pojo.Role;
import com.yyn.phone.provider.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Menu> showAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> showMenuByIds(Integer id) {
        List<Integer> menuIds = roleRepository.findRoleMenuByRoleId(id);
        List<Menu> menus = new ArrayList<>();
        for (Integer i:menuIds){
            menus.add(menuRepository.findAllById(i));
        }
        return menus;
    }
}
