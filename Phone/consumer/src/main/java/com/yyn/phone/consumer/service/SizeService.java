package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SizeService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Size> findAllSizes(){
        return  restTemplate.getForObject("http://service-provider/sizeList",List.class);
    }
}
