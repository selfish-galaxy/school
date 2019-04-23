package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public PageBean<Product> showAllProductsPage(int page,int size){
        return restTemplate.getForObject("http://service-provider/productList?page={1}&size={2}",PageBean.class,page,size);
    }

    public void addProduct(Product product){
        restTemplate.getForObject("http://service-provider/addProduct?pId={1}&pName={2}&braId={3}" +
                "&colorId={4}&sizeId={5}&pImg={6}&prices={7}&createTime={8}&description={9}",Void.class,
                product.getpId(),product.getpName(),product.getBraId(),product.getColorId(),product.getSizeId(),
                product.getpImg(),product.getPrices(),product.getCreateTime(),product.getDescription());
    }

    public void delProduct(Integer id){
        restTemplate.getForObject("http://service-provider/delProduct?id={1}",Void.class,id);
    }

    public Product selectOneProduct(Integer id){
        return restTemplate.getForObject("http://service-provider/selectOneProduct?id={1}",Product.class,id);
    }

    public void updateProduct(Product product){
        restTemplate.getForObject("http://service-provider/updateProduct?id={1}&pId={2}&pName={3}&braId={4}" +
                        "&colorId={5}&sizeId={6}&pImg={7}&prices={8}&createTime={9}&description={10}",Void.class,
                product.getId(),product.getpId(),product.getpName(),product.getBraId(),product.getColorId(), product.getSizeId(),
                product.getpImg(),product.getPrices(),product.getCreateTime(),product.getDescription());
    }

    public List<Product> selectProducts(Integer braId, String pName){
        return restTemplate.getForObject("http://service-provider/selectProducts?braId={1}&pName={2}",List.class,braId,pName);
    }
}
