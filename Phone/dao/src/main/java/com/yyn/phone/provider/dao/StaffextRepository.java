package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Staffext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StaffextRepository extends JpaRepository<Staffext,Integer>{

//    @Modifying
    @Transactional
    @Query(value = "select * from staffext where st_name=?1 and st_pwd=?2 ",nativeQuery=true)
    Staffext staffLogin(String stName, String stPwd);

    @Modifying
    @Transactional
    @Query(value = "update staffext set st_pwd=?1 where st_name=?2 ",nativeQuery=true)
    void updateStaffPassword(String stPwd, String stName);

}
