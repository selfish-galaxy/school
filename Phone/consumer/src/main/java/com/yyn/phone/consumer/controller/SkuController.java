package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.SkuService;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkuController {

    @Autowired
    private SkuService skuService;

    /*
    查询所有，显示列表
     */
    @RequestMapping("/skuList1")
    public String skuList1(Model model){
        model.addAttribute("skus",skuService.showAllSkus());
        return "seller/sku";
    }

    /*
    去添加页
     */
    @RequestMapping("/toSkuAdd")
    public String toSkuAdd(){
        return "seller/skuAdd";
    }

    /*
    添加
     */
    @RequestMapping("addSku")
    public String addSku(Sku sku){
        skuService.addSku(sku);
        return "redirect:skuList";
    }

    /*
   删除(真删除)
    */
    @RequestMapping("/delSku")
    public String delSku(Integer id){
        skuService.delSku(id);
        return "redirect:skuList";
    }

    /*
    去修改页
     */
    @RequestMapping("/toUpdateSku")
    public String toUpdateSku(Integer id,Model model){
        model.addAttribute("sku",skuService.selectOneSku(id));
        return "seller/skuUpdate";
    }

    /*
    修改
     */
    @RequestMapping("/updateSku")
    public String updateSku(Sku sku){
        skuService.updateSku(sku);
        return "redirect:skuList";
    }

    /*
    查询所有，显示列表（带分页）
     */
    @RequestMapping("/skuList")
    public String skuList(Integer currentPage, Integer size, Model model){
        if(currentPage == null){
            currentPage = 1;
        }
        if(size == null){
            size = 10;
        }
        StringBuilder params = new StringBuilder();
        params.append("size=" + size);
        PageBean<Sku> skuPageBean = skuService.skuPage(currentPage, size);
        skuPageBean.pageView("skuList", params.toString());
        model.addAttribute("skus",skuPageBean);
        return "seller/sku";
    }

    @RequestMapping("/selectSkuList")
    public String selectSkuByProId(Model model,Integer proId){
        model.addAttribute("skus",skuService.selectSkuByProId(proId));
        return "seller/sku";
    }
}
