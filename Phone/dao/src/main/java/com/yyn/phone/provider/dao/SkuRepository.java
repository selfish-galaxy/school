package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Sku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SkuRepository extends JpaRepository<Sku,Integer>{

    Page<Sku> findAllByProId(Integer id, Pageable pageable);

    @Transactional
    @Query(value = "select color_id from sku where pro_id=?1 ",nativeQuery=true)
    List findColorIdByProId(Integer proId);

    @Modifying
    @Transactional
    @Query(value = "update sku set amount=amount-1 where pro_id=?1 and color_id=?2 and size_id=?3 ",nativeQuery=true)
    void minusSkuAmount(Integer proId,String colorId,String sizeId);

    @Modifying
    @Transactional
    @Query(value = "update sku set amount=amount+1 where pro_id=?1 and color_id=?2 and size_id=?3 ",nativeQuery=true)
    void addSkuAmount(Integer proId,String colorId,String sizeId);
}
