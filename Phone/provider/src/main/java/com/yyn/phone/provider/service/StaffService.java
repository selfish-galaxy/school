package com.yyn.phone.provider.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> showAllStaffs();

    PageBean<Staff> showAll(Integer page, Integer size);

    void addStaff(Staff staff);

    void delStaff(Integer id);

    Staff selectOneStaff(Integer id);

    void updateStaff(Staff staff);

    Boolean staffLogin(String stName,String stPwd);

    Integer getStaffLoginStatus(String stName,String stPwd);

    void addCount(Integer staffId);

    void minusCount(Integer staffId);

    void updateStaffPassword(String stPwd,String stName);
}
