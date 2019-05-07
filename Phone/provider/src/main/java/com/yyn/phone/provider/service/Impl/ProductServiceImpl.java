package com.yyn.phone.provider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yyn.phone.provider.dao.ProductRepository;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Product;
import com.yyn.phone.provider.service.ProductService;
import com.yyn.phone.provider.tools.PageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public PageBean<Product> showAllProductsPage(int page,int size) {
//        return productRepository.findAll();
//        PageHelper.startPage(currentPage,pageSize);
//        List<Product> all = productRepository.findAll();
//        int size = all.size();
//        PageBean<Product> pageBean = new PageBean<Product>(currentPage,pageSize,size);
//        pageBean.setItems(all);
//        return pageBean.getItems();

        PageRequest pageRequest = PageRequest.of(page - 1,size);
        Page<Product> all = productRepository.findAll(pageRequest);
        PageBean<Product> pageBean = new PageBean<>();
        pageBean.setItems(all.getContent());
        Long totalElements = all.getTotalElements();
        pageBean.setTotalNum(totalElements.intValue());
        pageBean.setTotalPage(all.getTotalPages());
        pageBean.setPageSize(size);
        pageBean.setStartIndex(1);
        pageBean.setCurrentPage(page);
        return pageBean;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product selectOneProduct(Integer id) {
        return productRepository.getOne(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public PageBean<Product> selectProducts(Integer braId,String pName,int page,int size) {
        PageRequest of = PageRequest.of(page - 1,size);
        return PageTools.makePage(page,size,productRepository.findByBraIdAndPName(braId,pName,of));
    }
}
