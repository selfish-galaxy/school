package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.SizeRepository;
import com.yyn.phone.provider.pojo.Size;
import com.yyn.phone.provider.service.SizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sizeService")
public class SizeServiceImpl implements SizeService {

    @Resource
    private SizeRepository sizeRepository;

    @Override
    public List<Size> findAllSizes() {
        return sizeRepository.findAll();
    }
}
