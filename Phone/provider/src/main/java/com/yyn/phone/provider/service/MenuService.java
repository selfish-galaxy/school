package com.yyn.phone.provider.service;

import com.yyn.phone.provider.pojo.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> showAllMenus();

    List<Menu> showMenuByIds(Integer id);

}
