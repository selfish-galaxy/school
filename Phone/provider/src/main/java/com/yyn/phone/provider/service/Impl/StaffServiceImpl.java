package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.StaffRepository;
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

    @Override
    public List<Staff> showAllStaffs() {
        return null;
    }

    @Override
    public PageBean<Staff> showAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
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
}
