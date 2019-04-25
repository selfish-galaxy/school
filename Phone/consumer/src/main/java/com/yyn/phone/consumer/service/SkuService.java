package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SkuService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Sku> showAllSkus(){
        return  restTemplate.getForObject("http://service-provider/skuList",List.class);
    }

    public void addSku(Sku sku){
//        restTemplate.getForObject("http://service-provider/addSku?proId={1}&colorId={2}&sizeId={3}&price={4}&amount={5}",
//                Void.class, sku.getProId(),sku.getColorId(),sku.getSizeId(),sku.getPrice(),sku.getAmount());
        restTemplate.postForObject("http://service-provider/addSku?{sku}",sku,Sku.class);
    }

    public void delSku(Integer id){
//        restTemplate.getForObject("http://service-provider/delUser?id={1}",Void.class,id);
        restTemplate.delete("http://service-provider/delSku?id={1}",id);
    }

    public Sku selectOneSku(Integer id){
        return restTemplate.getForObject("http://service-provider/selectOneSku?id={1}",Sku.class,id);
    }

    public void updateSku(Sku sku){
        restTemplate.getForObject("http://service-provider/updateSku?skuid={1}&proId={2}&colorId={3}&sizeId={4}&price={5}&amount={6}",
                Void.class, sku.getSkuid(),sku.getProId(),sku.getColorId(),sku.getSizeId(),sku.getPrice(),sku.getAmount());
    }

    public PageBean<Sku> skuPage(Integer page, Integer size){
        PageBean<Sku> result = restTemplate.getForObject("http://service-provider/page?page={1}&size={2}", PageBean.class, page, size);
        return result;
    }

}
