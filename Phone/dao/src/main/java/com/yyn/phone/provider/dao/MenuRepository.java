package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{

//    @Modifying
    @Transactional
    @Query(value = "select * from menu where id=?1 ",nativeQuery=true)
    Menu findAllById(Integer id);
}
