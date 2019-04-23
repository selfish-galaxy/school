package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.BrandService;
import com.yyn.phone.consumer.service.ProductService;
import com.yyn.phone.provider.pojo.Brand;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @RequestMapping("/")
    public String index(){
        return "/seller/index";
    }

    /*
    查询所有，显示商品列表
     */
    @RequestMapping("/productList")
    public String productList(Model model,Integer currentPage,Integer size){
//        model.addAttribute("products",productService.showAllProducts(currentPage,pageSize));
        model.addAttribute("product",new Product());
        model.addAttribute("brands",brandService.showAllBrands());
        if(currentPage == null){
            currentPage = 1;
        }
        if(size == null){
            size = 10;
        }
        StringBuilder params = new StringBuilder();
        params.append("size=" + size);
        PageBean<Product> productPageBean = productService.showAllProductsPage(currentPage, size);
        productPageBean.pageView("productList", params.toString());
        model.addAttribute("products",productPageBean);
        return "seller/product";
    }

    /*
    去商品添加页
     */
    @RequestMapping("/toProductAdd")
    public String toProductAdd(Model model) {
        model.addAttribute("brands",brandService.showAllBrands());
        return "seller/productAdd";
    }

    /*
    添加商品
     */
    @RequestMapping("/addProduct")
    public String addProduct(Product product,Integer braId){
        product.setBraId(braId);
        productService.addProduct(product);
        return "redirect:productList";
    }

    /*
    删除商品
     */
    @RequestMapping("/delProduct")
    public String delProduct(Integer id){
        productService.delProduct(id);
        return "redirect:productList";
    }

    /*
    去修改页
     */
    @RequestMapping("/toUpdateProduct")
    public String toUpdateProduct(Integer id,Model model) {
        model.addAttribute("brands",brandService.showAllBrands());
        model.addAttribute("product",productService.selectOneProduct(id));
        return "seller/productUpdate";
    }

    /*
    修改商品
     */
    @RequestMapping("/updateProduct")
    public String updateProduct(Product product){
        productService.updateProduct(product);
        return "redirect:productList";
    }

    /*
    查询商品
     */
    @RequestMapping("/selectProducts")
    public String selectProducts(Model model,Integer braId,String pName){
        Product product = new Product();
        product.setBraId(braId);
        product.setpName(pName);
        model.addAttribute("brands", brandService.showAllBrands());
        model.addAttribute("product",product);
        model.addAttribute("products",productService.selectProducts(braId, pName));
        return "/seller/product";
    }

}
