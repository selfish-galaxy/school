package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer>{


}
