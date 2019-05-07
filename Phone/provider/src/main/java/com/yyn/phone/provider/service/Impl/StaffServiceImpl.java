package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.StaffRepository;
import com.yyn.phone.provider.dao.StaffextRepository;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.Staff;
import com.yyn.phone.provider.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;
//    @Autowired
//    private StaffextRepository staffextRepository;

    @Override
    public List<Staff> showAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public PageBean<Staff> showAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Staff> all = staffRepository.findAll(pageRequest);
        PageBean<Staff> pageBean = new PageBean<>();
        pageBean.setItems(all.getContent());
        Long totalElements = all.getTotalElements();
        pageBean.setTotalNum(totalElements.intValue());
        pageBean.setTotalPage(all.getTotalPages());
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(size);
        pageBean.setStartIndex(1);
        return pageBean;
    }

    @Override
    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void delStaff(Integer id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff selectOneStaff(Integer id) {
        return staffRepository.getOne(id);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public Boolean staffLogin(String stName, String stPwd) {
        Staff staff = staffRepository.staffLogin(stName, stPwd);
//        if (stName.equals(staff.getStName()) && stPwd.equals(staff.getStPwd())){
//            return true;
//        }else {
        if (staff == null){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public Integer getStaffLoginStatus(String stName, String stPwd) {
        return staffRepository.staffLogin(stName, stPwd).getStatus();
    }

    @Override
    public void addCount(Integer staffId) {
        staffRepository.addCount(staffId);
    }

    @Override
    public void minusCount(Integer staffId) {
        staffRepository.minusCount(staffId);
    }

    @Override
    public void updateStaffPassword(String stPwd, String stName) {
        staffRepository.updateStaffPassword(stPwd, stName);
    }
}
