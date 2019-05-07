package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ColorService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Color> findAllColors(){
        return  restTemplate.getForObject("http://service-provider/colorList",List.class);
    }
}
