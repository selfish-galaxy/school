package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.Brand;
import com.yyn.phone.provider.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/brandList")
    public List<Brand> showAllBrands(){
        return brandService.showAllBrands();
    }

    @RequestMapping("/addBrand")
    public void addBrand(Brand brand){
        brandService.addBrand(brand);
    }

    @RequestMapping("/delBrand")
    public void delBrand(Integer id){
        brandService.delBrand(id);
    }

    @RequestMapping("/selectOneBrand")
    public Brand selectOneBrand(Integer id){
        return brandService.selectOneBrand(id);
    }

    @RequestMapping("/updateBrand")
    public void updateBrand(Brand brand){
        brandService.updateBrand(brand);
    }
}
