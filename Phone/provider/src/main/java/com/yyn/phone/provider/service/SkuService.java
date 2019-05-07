package com.yyn.phone.provider.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Sku;

import java.util.List;

public interface SkuService {

    List<Sku> showAllSkus();

    PageBean<Sku> showAll(Integer page, Integer size);

    void addSku(Sku sku);

    void delSku(Integer id);

    Sku selectOneSku(Integer id);

    void updateSku(Sku sku);

    PageBean<Sku> selectByProId(Integer proId,Integer page, Integer size);

    List findColorIdByProId(Integer proId);

    void minusSkuAmount(Integer proId,String colorId,String sizeId);

    void addSkuAmount(Integer proId,String colorId,String sizeId);
}
