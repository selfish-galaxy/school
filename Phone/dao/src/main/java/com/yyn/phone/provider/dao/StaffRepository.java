package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{

    @Transactional
    @Query(value = "select * from staff where st_name=?1 and st_pwd=?2 ",nativeQuery=true)
    Staff staffLogin(String stName,String stPwd);

    @Modifying
    @Transactional
    @Query(value = "update staff set st_pwd=?1 where st_name=?2 ",nativeQuery=true)
    void updateStaffPassword(String stPwd,String stName);

    @Modifying
    @Transactional
    @Query(value = "update staff set count=count+1 , bonus=count*50 , salary=bonus+basic where id=?1 ",nativeQuery=true)
    void addCount(Integer staffId);

    @Modifying
    @Transactional
    @Query(value = "update staff set count=count-1 , bonus=count*50 , salary=bonus+basic where id=?1 ",nativeQuery=true)
    void minusCount(Integer staffId);
}
