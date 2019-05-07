package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.*;
import com.yyn.phone.provider.pojo.Order;
import com.yyn.phone.provider.pojo.Ordery;
import com.yyn.phone.provider.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OrderyController {

    @Autowired
    private OrderyService orderyService;
    @Autowired
    private SkuService skuService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;

    /*
    查询所有，显示列表
     */
    @RequestMapping("/orderyList1")
    public String orderyList1(Model model){
        model.addAttribute("orderys", orderyService.showAllOrderys());
        return "seller/order";
    }

    /*
    去添加页
     */
    @RequestMapping("/toOrderyAdd")
    public String toOrderyAdd(Model model){
        model.addAttribute("staffs",staffService.showAllStaffs());
        model.addAttribute("clist",colorService.findAllColors());
        model.addAttribute("slist",sizeService.findAllSizes());
        return "seller/orderAdd";
    }

    /*
    添加
     */
    @RequestMapping("addOrdery")
    public String addOrdery(Ordery ordery,Integer staffId,Integer proId,String colorId,String sizeId){
//        System.out.println(staffId);
//        System.out.println(colorId);
//        System.out.println(sizeId);
        ordery.setOrderTime(new Date());
        orderyService.addOrdery(ordery);
        //出单后库存进行减量
        skuService.minusSkuAmount(proId, colorId, sizeId);
        //相应的经手人销量上涨
        staffService.addCount(staffId);
        return "redirect:orderyList";
    }

    /*
   取消订单
    */
    @RequestMapping("/cancelOrdery")
    public String cancelOrdery(Integer id,Ordery ordery,Integer staffId,Integer proId,String colorId,String sizeId){
//        orderyService.delOrdery(id);
//        Ordery ordery1 = orderyService.selectOneOrdery(id);
//        System.out.println(staffId);
//        Integer integer = Integer.valueOf(staffId);
//        System.out.println(proId);
//        System.out.println(colorId);
//        System.out.println(sizeId);
        orderyService.cancelOrdery(id);
        //库存数量需要回滚
        skuService.addSkuAmount(proId, colorId, sizeId);
        //经手人销量也需要回滚
        staffService.minusCount(staffId);
        return "redirect:orderyList";
    }

    /*
    去修改页
     */
    @RequestMapping("/toUpdateOrdery")
    public String toUpdateOrdery(Integer id,Model model){
        model.addAttribute("ordery", orderyService.selectOneOrdery(id));
        return "seller/orderUpdate";
    }

    /*
    修改
     */
    @RequestMapping("/updateOrdery")
    public String updateOrdery(Ordery ordery,Integer staffId){
//        System.out.println(staffId);
        ordery.setOrderTime(new Date());
        orderyService.updateOrdery(ordery);
        return "redirect:orderyList";
    }

    /*
    查询所有，显示列表（带分页）
     */
    @RequestMapping("/orderyList")
    public String orderyList(Integer currentPage, Integer size, Model model){
        if(currentPage == null){
            currentPage = 1;
        }
        if(size == null){
            size = 10;
        }
        PageBean<Ordery> orderyPageBean = orderyService.orderyPage(currentPage, size);
//        userPageBean.pageView("userList", params.toString());
        orderyPageBean.pageView("orderyList");
        model.addAttribute("orderys",orderyPageBean);
        return "seller/order";
    }
}
