package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BrandService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Brand> showAllBrands(){
        return  restTemplate.getForObject("http://service-provider/brandList",List.class);
    }

    public void addBrand(Brand brand){
        restTemplate.getForObject("http://service-provider/addBrand?id={1}&bName={2}&bImg={3}&introduction={4}",
                Void.class,brand.getId(),brand.getbName(),brand.getbImg(),brand.getIntroduction());
    }

    public void delBrand(Integer id){
        restTemplate.getForObject("http://service-provider/delBrand?id={1}",Void.class,id);
//        restTemplate.delete("http://service-provider/delBrand?id={1}",Void.class,id);
    }

    public Brand selectOneBrand(Integer id){
        return restTemplate.getForObject("http://service-provider/selectOneBrand?id={1}",Brand.class,id);
    }

    public void updateBrand(Brand brand){
        restTemplate.getForObject("http://service-provider/updateBrand?id={1}&bName={2}&bImg={3}&introduction={4}",
                Brand.class,brand.getId(),brand.getbName(),brand.getbImg(),brand.getIntroduction());
    }

}
