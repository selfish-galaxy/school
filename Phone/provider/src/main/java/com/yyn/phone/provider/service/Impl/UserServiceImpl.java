package com.yyn.phone.provider.service.Impl;

import com.yyn.phone.provider.dao.UserRepository;
import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.User;
import com.yyn.phone.provider.service.UserService;
import com.yyn.phone.provider.tools.PageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Resource
    private PageTools pageTools;

    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public PageBean<User> showAll(Integer page, Integer size) {
//        PageRequest pageRequest = PageRequest.of(page - 1, size);
//        Page<User> all = userRepository.findAll(pageRequest);
//        PageBean result = new PageBean();
//        result.setItems(all.getContent());
//        Long totalElements = all.getTotalElements();
//        result.setTotalNum(totalElements.intValue());
//        result.setTotalPage(all.getTotalPages());
//        result.setPageSize(size);
//        result.setStartIndex(1);
//        result.setCurrentPage(page);
//
//        return result;

        PageRequest pageRequest = PageRequest.of(page - 1,size);
//        return pageTools.makePage(page,size,userRepository.findAll(pageRequest));
        return PageTools.makePage(page,size,userRepository.findAll(pageRequest));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void delUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User selectOneUser(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
