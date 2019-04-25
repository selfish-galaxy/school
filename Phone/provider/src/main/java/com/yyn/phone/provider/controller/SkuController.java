package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Sku;
import com.yyn.phone.provider.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkuController {

    @Autowired
    private SkuService skuService;

    @RequestMapping("/skuList")
    public List<Sku> showAllSkus(){
        return skuService.showAllSkus();
    }

    @RequestMapping("/addSku")
    public void addSku(Sku sku){
        skuService.addSku(sku);
    }

    @RequestMapping("/delSku")
    public void delSku(Integer id){
        skuService.delSku(id);
    }

    @RequestMapping("/selectOneSku")
    public Sku selectOneSku(Integer id){
        return skuService.selectOneSku(id);
    }

    @RequestMapping("/updateSku")
    public void updateSku(Sku sku){
        skuService.updateSku(sku);
    }

    @RequestMapping("/page")
    public PageBean<Sku> skuPage(Integer page, Integer size){
        return skuService.showAll(page, size);
    }
}
