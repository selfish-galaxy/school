package com.yyn.phone.provider.service;

import com.yyn.phone.provider.pojo.Ordery;
import com.yyn.phone.provider.pojo.PageBean;

import java.util.List;

public interface OrderyService {

    List<Ordery> showAllOrderys();

    PageBean<Ordery> showAll(Integer page, Integer size);

    void addOrdery(Ordery ordery);

    void delOrdery(Integer id);

    Ordery selectOneOrdery(Integer id);

    void updateOrdery(Ordery ordery);

    void cancelOrdery(Integer id);
}
