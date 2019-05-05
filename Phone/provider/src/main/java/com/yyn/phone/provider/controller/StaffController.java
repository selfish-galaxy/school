package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;
import com.yyn.phone.provider.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/staffList")
    public List<Staff> showAllStaffs(){
        return staffService.showAllStaffs();
    }

    @RequestMapping("/addStaff")
    public void addStaff(Staff staff){
        staffService.addStaff(staff);
    }

    @RequestMapping("/delStaff")
    public void delStaff(Integer id){
        staffService.delStaff(id);
    }

    @RequestMapping("/selectOneStaff")
    public Staff selectOneStaff(Integer id){
        return staffService.selectOneStaff(id);
    }

    @RequestMapping("/updateStaff")
    public void updateStaff(Staff staff){
        staffService.updateStaff(staff);
    }

    @RequestMapping("/pageStaff")
    public PageBean<Staff> staffPage(Integer page, Integer size){
        return staffService.showAll(page, size);
    }

    @RequestMapping("/staffLogin")
    public Boolean staffLogin(String stName,String stPwd){
        return staffService.staffLogin(stName,stPwd);
    }

    @RequestMapping("/getStaffLoginStatus")
    public Integer getStaffLoginStatus(String stName,String stPwd){
        return staffService.getStaffLoginStatus(stName,stPwd);
    }
}
