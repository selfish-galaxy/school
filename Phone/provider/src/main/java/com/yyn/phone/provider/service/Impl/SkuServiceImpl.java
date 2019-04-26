package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.SkuRepository;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Sku;
import com.yyn.phone.provider.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skuService")
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuRepository skuRepository;

    @Override
    public List<Sku> showAllSkus() {
        return skuRepository.findAll();
    }

    @Override
    public PageBean<Sku> showAll(Integer page, Integer size) {
        PageRequest of = PageRequest.of(page - 1, size);
        Page<Sku> all = skuRepository.findAll(of);
        PageBean<Sku> pageBean = new PageBean<>();
        pageBean.setItems(all.getContent());
        pageBean.setTotalNum(all.getSize()); //1
//        pageBean.setTotalNum(skuRepository.findAll().size()); //2
//        Long totalElements = all.getTotalElements();  //3
//        pageBean.setTotalNum(totalElements.intValue()); //3
        pageBean.setTotalPage(all.getTotalPages());
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(size);
        return pageBean;
    }

    @Override
    public void addSku(Sku sku) {
        skuRepository.save(sku);
    }

    @Override
    public void delSku(Integer id) {
        skuRepository.deleteById(id);
    }

    @Override
    public Sku selectOneSku(Integer id) {
        return skuRepository.getOne(id);
    }

    @Override
    public void updateSku(Sku sku) {
        skuRepository.save(sku);
    }

    @Override
    public List<Sku> selectByProId(Integer proId) {
        return skuRepository.findAllByProId(proId);
    }
}
