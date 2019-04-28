package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Sku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuRepository extends JpaRepository<Sku,Integer>{

    Page<Sku> findAllByProId(Integer id, Pageable pageable);
}
