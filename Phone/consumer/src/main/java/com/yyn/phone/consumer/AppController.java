package com.yyn.phone.consumer;

import com.github.pagehelper.PageHelper;
import com.yyn.phone.consumer.service.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@RestController
public class AppController {

    @Bean(name = "restTemplate")
    @LoadBalanced  //做负载均衡的
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    BrandService brandService(){
        return new BrandService();
    }

    @Bean
    ProductService productService() {
        return new ProductService();
    }

    @Bean
    UserService userService(){
        return new UserService();
    }

    @Bean
    StaffService staffService(){
        return new StaffService();
    }

    @Bean
    SkuService skuService(){
        return new SkuService();
    }

//    //配置mybatis的分页插件pageHelper
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        properties.setProperty("reasonable","true");
//        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
}
