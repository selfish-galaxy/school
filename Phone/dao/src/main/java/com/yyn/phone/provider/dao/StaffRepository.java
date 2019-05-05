package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{

//    @Modifying
    @Transactional
    @Query(value = "select * from staff where st_name=?1 and st_pwd=?2 ",nativeQuery=true)
    Staff staffLogin(String stName,String stPwd);
}
