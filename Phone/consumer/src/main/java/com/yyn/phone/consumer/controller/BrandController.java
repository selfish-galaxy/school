package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.BrandService;
import com.yyn.phone.provider.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    /*
    查询所有，显示列表
     */
    @RequestMapping("/brandList")
    public String brandList(Model model){
        model.addAttribute("brands",brandService.showAllBrands());
        return "seller/brand";
    }

    /*
    去添加页
     */
    @RequestMapping("/toBrandAdd")
    public String toBrandAdd(){
        return "seller/brandAdd";
    }

    /*
    添加品牌
     */
    @RequestMapping("addBrand")
    public String addBrand(Brand brand){
        brandService.addBrand(brand);
        return "redirect:brandList";
    }

    /*
   删除类目(真删除)
    */
    @RequestMapping("/delBrand")
    public String delBrand(Integer id){
        brandService.delBrand(id);
        return "redirect:brandList";
    }

    /*
    去修改页
     */
    @RequestMapping("/toUpdateBrand")
    public String toUpdateBrand(Integer id,Model model){
        model.addAttribute("brand",brandService.selectOneBrand(id));
        return "seller/brandUpdate";
    }

    /*
    修改
     */
    @RequestMapping("/updateBrand")
    public String updateBrand(Brand brand){
        brandService.updateBrand(brand);
        return "redirect:brandList";
    }
}
