package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StaffService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<Staff> showAllStaffs(){
        return  restTemplate.getForObject("http://service-provider/staffList",List.class);
    }

    public void addStaff(Staff staff){
        restTemplate.getForObject("http://service-provider/addStaff?stName={1}&stPwd={2}&stSex={3}&dept={4}&count={5}&basic={6}&bonus={7}&salary={8}&status={9}",
                Void.class, staff.getStName(),"123456",staff.getStSex(),staff.getDept(),0,staff.getBasic(),0,staff.getSalary(),staff.getStatus());
    }

    public void delStaff(Integer id){
//        restTemplate.getForObject("http://service-provider/delUser?id={1}",Void.class,id);
        restTemplate.delete("http://service-provider/delStaff?id={1}",id);
    }

    public Staff selectOneStaff(Integer id){
        return restTemplate.getForObject("http://service-provider/selectOneStaff?id={1}",Staff.class,id);
    }

    public void updateStaff(Staff staff){
        restTemplate.getForObject("http://service-provider/updateStaff?id={1}&stName={2}&stSex={3}&dept={4}&count={5}&basic={6}&bonus={7}&salary={8}&status={9}",
                Void.class, staff.getId(),staff.getStName(),staff.getStSex(),staff.getDept(),staff.getCount(),staff.getBasic(),staff.getCount()*50,staff.getSalary(),staff.getStatus());
    }

    public PageBean<Staff> staffPage(Integer page, Integer size){
        PageBean<Staff> result = restTemplate.getForObject("http://service-provider/pageStaff?page={1}&size={2}", PageBean.class, page, size);
        return result;
    }

    public Boolean staffLogin(String stName,String stPwd){
        return restTemplate.getForObject("http://service-provider/staffLogin?stName={1}&stPwd={2}",Boolean.class, stName, stPwd);
    }

    public Integer getStaffLoginStatus(String stName,String stPwd){
        return restTemplate.getForObject("http://service-provider/getStaffLoginStatus?stName={1}&stPwd={2}",Integer.class, stName, stPwd);
    }

    public void addCount(Integer staffId) {
        restTemplate.getForObject("http://service-provider/addCount?staffId={1}",Staff.class,staffId);
    }

    public void minusCount(Integer staffId) {
        restTemplate.getForObject("http://service-provider/minusCount?staffId={1}",Staff.class,staffId);
    }

    public void updateStaffPassword(String stPwd,String stName){
        restTemplate.getForObject("http://service-provider/updatePassword?stPwd={1}&stName={2}",Integer.class, stPwd, stName);
    }

}
