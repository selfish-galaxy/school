package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.ColorRepository;
import com.yyn.phone.provider.pojo.Color;
import com.yyn.phone.provider.service.ColorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("colorService")
public class ColorServiceImpl implements ColorService {

    @Resource
    private ColorRepository colorRepository;

    @Override
    public List<Color> findAllColors() {
        return colorRepository.findAll();
    }
}
