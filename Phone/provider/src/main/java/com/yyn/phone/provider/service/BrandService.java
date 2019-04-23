package com.yyn.phone.provider.service;


import com.yyn.phone.provider.pojo.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> showAllBrands();

    void addBrand(Brand brand);

    void delBrand(Integer id);

    Brand selectOneBrand(Integer id);

    void updateBrand(Brand brand);
}
