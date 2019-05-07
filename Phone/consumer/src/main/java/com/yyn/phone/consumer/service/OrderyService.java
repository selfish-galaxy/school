package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.Ordery;
import com.yyn.phone.provider.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrderyService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Ordery> showAllOrderys(){
        return  restTemplate.getForObject("http://service-provider/orderyList",List.class);
    }

    public void addOrdery(Ordery ordery){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(ordery.getTime());
        restTemplate.getForObject("http://service-provider/addOrdery?userId={1}&proId={2}&colorId={3}&sizeId={4}&money={5}&staffId={6}&orderTime={7}&orderCondition={8}",
                Void.class, ordery.getUserId(),ordery.getProId(),ordery.getColorId(),ordery.getSizeId(),ordery.getMoney(),ordery.getStaffId(),ordery.getOrderTime(),"出单");
    }

    public void delOrdery(Integer id){
//        restTemplate.getForObject("http://service-provider/delUser?id={1}",Void.class,id);
        restTemplate.delete("http://service-provider/delOrdery?id={1}",id);
    }

    public Ordery selectOneOrdery(Integer id){
        return restTemplate.getForObject("http://service-provider/selectOneOrdery?id={1}",Ordery.class,id);
    }

    public void updateOrdery(Ordery ordery){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(ordery.getTime());
        restTemplate.getForObject("http://service-provider/updateOrdery?id={1}&userId={2}&proId={3}&colorId={4}&sizeId={5}&money={6}&staffId={7}&orderTime={8}&orderCondition={9}",
                Void.class, ordery.getId(),ordery.getUserId(),ordery.getProId(),ordery.getColorId(),ordery.getSizeId(),ordery.getMoney(),ordery.getStaffId(),ordery.getOrderTime(),"更正出单");
    }

    public PageBean<Ordery> orderyPage(Integer page, Integer size){
        PageBean<Ordery> result = restTemplate.getForObject("http://service-provider/pageOrdery?page={1}&size={2}", PageBean.class, page, size);
        return result;
    }

    public void cancelOrdery(Integer id){
//        restTemplate.getForObject("http://service-provider/updateOrdery?orderCondition={1}",
//                Void.class, "shouhoutuihuo");  //ordery.getId(),ordery.getOrderCondition()id={1}
        restTemplate.getForObject("http://service-provider/cancelOrdery?id={1}",Void.class,id);
    }

}
