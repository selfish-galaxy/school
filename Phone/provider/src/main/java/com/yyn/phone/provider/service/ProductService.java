package com.yyn.phone.provider.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Product;

import java.util.List;

public interface ProductService {

    PageBean<Product> showAllProductsPage(int page, int size);

    void addProduct(Product product);

    void delProduct(Integer id);

    Product selectOneProduct(Integer id);

    void updateProduct(Product product);

    List<Product> selectProducts(Integer braId,String pName);
}
