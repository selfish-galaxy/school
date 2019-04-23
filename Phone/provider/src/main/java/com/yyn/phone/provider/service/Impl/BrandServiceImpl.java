package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.BrandRepository;
import com.yyn.phone.provider.pojo.Brand;
import com.yyn.phone.provider.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> showAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delBrand(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand selectOneBrand(Integer id) {
        return brandRepository.getOne(id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandRepository.save(brand);
    }
}
