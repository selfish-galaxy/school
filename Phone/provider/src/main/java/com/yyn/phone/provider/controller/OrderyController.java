package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.Ordery;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.service.OrderyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderyController {

    @Autowired
    private OrderyService orderyService;

    @RequestMapping("/orderList")
    public List<Ordery> showAllOrderys(){
        return orderyService.showAllOrderys();
    }

    @RequestMapping("/addOrdery")
    public void addOrdery(Ordery ordery){
        orderyService.addOrdery(ordery);
    }

    @RequestMapping("/delOrdery")
    public void delOrdery(Integer id){
        orderyService.delOrdery(id);
    }

    @RequestMapping("/selectOneOrdery")
    public Ordery selectOneOrdery(Integer id){
        return orderyService.selectOneOrdery(id);
    }

    @RequestMapping("/updateOrdery")
    public void updateOrdery(Ordery ordery){
        orderyService.updateOrdery(ordery);
    }

    @RequestMapping("/pageOrdery")
    public PageBean<Ordery> orderyPage(Integer page, Integer size){
        return orderyService.showAll(page, size);
    }

    @RequestMapping("/cancelOrdery")
    public void cancelOrdery(Integer id){
        orderyService.cancelOrdery(id);
    }
}
