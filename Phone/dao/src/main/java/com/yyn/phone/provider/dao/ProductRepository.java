package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>,JpaSpecificationExecutor<Product>{

    @Modifying
    @Transactional
    @Query(value = "select * from Product where bra_id=?1 and p_name like concat('%',?2,'%')",nativeQuery=true)
    List<Product> findByBraIdAndPName(Integer braId,String pName);

}
