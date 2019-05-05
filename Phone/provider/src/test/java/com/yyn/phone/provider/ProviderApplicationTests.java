package com.yyn.phone.provider;

import com.yyn.phone.provider.dao.RoleRepository;
import com.yyn.phone.provider.dao.UserRepository;
import com.yyn.phone.provider.pojo.*;
import com.yyn.phone.provider.service.MenuService;
import com.yyn.phone.provider.service.ProductService;
import com.yyn.phone.provider.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests {

	@Resource
	private ProductService productService;
	@Autowired
	private UserRepository userRepository;
	@Resource
	private UserService userService;
	@Resource
	private MenuService menuService;
	@Resource
	private RoleRepository roleRepository;


	@Test
	public void contextLoads() {

		PageBean<User> userPageBean = userService.showAll(1, 3);
//		PageRequest pageRequest = PageRequest.of(0, 2);
//		Page<User> all = userRepository.findAll(pageRequest);
		System.out.println(userPageBean.toString());
	}

	@Test
	public void fff() {
		List<Menu> menus = menuService.showMenuByIds(1);
		System.out.println(menus);
		for (Menu m:menus){
			System.out.println(m);
			System.out.println(m.getUrlName());
			System.out.println(m.getUrl());
		}

//		List<Role> roleMenuByRoleId = roleRepository.findRoleMenuByRoleId(1);
//		List<Integer> roleMenuByRoleId = roleRepository.findRoleMenuByRoleId(1);
//		System.out.println(roleMenuByRoleId);
//		for (Integer m:roleMenuByRoleId){
//			System.out.println(m);
//		}
	}

}
