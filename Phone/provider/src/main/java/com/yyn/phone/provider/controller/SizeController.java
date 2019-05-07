package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.Size;
import com.yyn.phone.provider.service.SizeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SizeController {

    @Resource
    private SizeService sizeService;

    @RequestMapping("/sizeList")
    public List<Size> findAllSizes(){
        return sizeService.findAllSizes();
    }
}
