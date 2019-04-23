package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Product;
import com.yyn.phone.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public PageBean<Product> showAllProducts(int page, int size){
        return productService.showAllProductsPage(page,size);
    }

    @RequestMapping("/addProduct")
    public void addProduct(Product product){
        productService.addProduct(product);
    }

    @RequestMapping("/delProduct")
    public void delProduct(Integer id){
        productService.delProduct(id);
    }

    @RequestMapping("/selectOneProduct")
    public Product selectOneProduct(Integer id){
        return productService.selectOneProduct(id);
    }

    @RequestMapping("/updateProduct")
    public void updateProduct(Product product){
        productService.updateProduct(product);
    }

    @RequestMapping("/selectProducts")
    public List<Product> selectProducts(Integer braId,String pName){
        return productService.selectProducts(braId, pName);
    }
}
