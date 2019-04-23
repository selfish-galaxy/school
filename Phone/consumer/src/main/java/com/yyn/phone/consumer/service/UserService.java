package com.yyn.phone.consumer.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.RestPage;
import com.yyn.phone.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    public List<User> showAllUsers(){
        return  restTemplate.getForObject("http://service-provider/userList",List.class);
    }

    public void addUser(User user){
        restTemplate.getForObject("http://service-provider/addUser?uName={1}&uSex={2}&uAge={3}&job={4}&address={5}&uTel={6}&buy={7}&comment={8}",
                Void.class, user.getuName(),user.getuSex(),user.getuAge(),user.getJob(),user.getAddress(),user.getuTel(),user.getBuy(),user.getComment());
    }

    public void delUser(Integer id){
//        restTemplate.getForObject("http://service-provider/delUser?id={1}",Void.class,id);
        restTemplate.delete("http://service-provider/delUser?id={1}",id);
    }

    public User selectOneUser(Integer id){
        return restTemplate.getForObject("http://service-provider/selectOneUser?id={1}",User.class,id);
    }

    public void updateUser(User user){
        restTemplate.getForObject("http://service-provider/updateUser?id={1}&uName={2}&uSex={3}&uAge={4}&job={5}&address={6}&uTel={7}&buy={8}&comment={9}",
                Void.class, user.getId(),user.getuName(),user.getuSex(),user.getuAge(),user.getJob(),user.getAddress(),user.getuTel(),user.getBuy(),user.getComment());
    }

    public PageBean<User> userPage(Integer page, Integer size){
        PageBean<User> result = restTemplate.getForObject("http://service-provider/page?page={1}&size={2}", PageBean.class, page, size);
        return result;
    }

}
