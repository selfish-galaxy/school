package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.BrandService;
import com.yyn.phone.provider.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam(value = "bImg") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://ideaWorkspace//schoolProject//school//Phone//consumer//src//main//resources//img//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/img/" + fileName;
        model.addAttribute("bImg", filename);
        return "seller/brandAdd";
    }

}
