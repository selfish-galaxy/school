package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Ordery;
import com.yyn.phone.provider.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderyRepository extends JpaRepository<Ordery,Integer>{

    @Modifying
    @Transactional
    @Query(value = "update ordery set order_condition='售后退货' where id=?1 ",nativeQuery=true)
    void cancelOrder(Integer id);
}
