package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.OrderyRepository;
import com.yyn.phone.provider.pojo.Ordery;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.service.OrderyService;
import com.yyn.phone.provider.tools.PageTools;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderyServiceImpl implements OrderyService {

    @Resource
    private OrderyRepository orderyRepository;

    @Override
    public List<Ordery> showAllOrderys() {
        return orderyRepository.findAll();
    }

    @Override
    public PageBean<Ordery> showAll(Integer page, Integer size) {
        PageRequest of = PageRequest.of(page - 1, size);
        return PageTools.makePage(page,size, orderyRepository.findAll(of));
    }

    @Override
    public void addOrdery(Ordery ordery) {
        orderyRepository.save(ordery);
    }

    @Override
    public void delOrdery(Integer id) {
        orderyRepository.deleteById(id);
    }

    @Override
    public Ordery selectOneOrdery(Integer id) {
        return orderyRepository.getOne(id);
    }

    @Override
    public void updateOrdery(Ordery ordery) {
        orderyRepository.save(ordery);
    }

    @Override
    public void cancelOrdery(Integer id) {
        orderyRepository.cancelOrder(id);
    }
}
