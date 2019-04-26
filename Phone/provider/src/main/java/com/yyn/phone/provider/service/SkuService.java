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

    List<Sku> selectByProId(Integer proId);
}
