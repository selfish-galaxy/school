package com.yyn.phone.provider;

import com.yyn.phone.provider.dao.UserRepository;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Product;
import com.yyn.phone.provider.pojo.User;
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
	@Test
	public void contextLoads() {

		PageBean<User> userPageBean = userService.showAll(1, 3);
//		PageRequest pageRequest = PageRequest.of(0, 2);
//		Page<User> all = userRepository.findAll(pageRequest);
		System.out.println(userPageBean.toString());
	}



}
