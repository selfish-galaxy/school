package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.Color;
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

    @RequestMapping("/pageSku")
    public PageBean<Sku> skuPage(Integer page, Integer size){
        return skuService.showAll(page, size);
    }

    @RequestMapping("/selectSku")
    public PageBean<Sku> selectByProId(Integer id,Integer page, Integer size){
        return skuService.selectByProId(id, page, size);
    }

    @RequestMapping("/findColorList")
    public List<Color> findColorIdByProId(Integer proId){
        return skuService.findColorIdByProId(proId);
    }

    @RequestMapping("/minusSkuAmount")
    public void minusSkuAmount(Integer proId,String colorId,String sizeId){
        skuService.minusSkuAmount(proId, colorId, sizeId);
    }

    @RequestMapping("/addSkuAmount")
    public void addSkuAmount(Integer proId, String colorId, String sizeId) {
        skuService.addSkuAmount(proId, colorId, sizeId);
    }
}
