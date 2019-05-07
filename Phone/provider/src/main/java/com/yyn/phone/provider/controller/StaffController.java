package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;
import com.yyn.phone.provider.service.StaffService;
//import com.yyn.phone.provider.tools.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    public Boolean staffLogin(String stName, String stPwd, HttpSession session){
//        session.setAttribute(WebSecurityConfig.SESSION_KEY, stName);
        return staffService.staffLogin(stName,stPwd);
    }

    @RequestMapping("/getStaffLoginStatus")
    public Integer getStaffLoginStatus(String stName,String stPwd){
        return staffService.getStaffLoginStatus(stName,stPwd);
    }

    @RequestMapping("/addCount")
    public void addCount(Integer staffId) {
        staffService.addCount(staffId);
    }

    @RequestMapping("/minusCount")
    public void minusCount(Integer staffId) {
        staffService.minusCount(staffId);
    }

    @RequestMapping("/updatePassword")
    public void updateStaffPassword(String stPwd,String stName){
        staffService.updateStaffPassword(stPwd, stName);
    }
}
