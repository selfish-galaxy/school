package com.yyn.phone.provider.tools;

import com.yyn.phone.provider.pojo.PageBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PageTools {

    public static PageBean makePage(Integer page, Integer size, Page all){
//        PageRequest pageRequest = PageRequest.of(page - 1,size);
        PageBean<Object> objectPageBean = new PageBean<>();
        objectPageBean.setItems(all.getContent());
        Long totalElements = all.getTotalElements();
        objectPageBean.setTotalNum(totalElements.intValue());
        objectPageBean.setTotalPage(all.getTotalPages());
        objectPageBean.setStartIndex(1);
        objectPageBean.setCurrentPage(page);
        objectPageBean.setPageSize(size);
        return objectPageBean;
    }
}
