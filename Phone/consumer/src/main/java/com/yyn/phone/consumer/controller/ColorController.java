package com.yyn.phone.consumer.controller;

import com.yyn.phone.consumer.service.ColorService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ColorController {

    @Resource
    private ColorService colorService;

    public String findAllColors(){
        return "";
    }
}
