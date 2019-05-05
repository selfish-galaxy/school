package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MenuService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Menu> showMenusByIds(Integer id){
        return  restTemplate.getForObject("http://service-provider/menuList?id={1}",List.class,id);
    }
}
