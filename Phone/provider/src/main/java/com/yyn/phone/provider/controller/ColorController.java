package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.Color;
import com.yyn.phone.provider.service.ColorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ColorController {

    @Resource
    private ColorService colorService;

    @RequestMapping("/colorList")
    public List<Color> findAllColors(){
        return colorService.findAllColors();
    }
}
