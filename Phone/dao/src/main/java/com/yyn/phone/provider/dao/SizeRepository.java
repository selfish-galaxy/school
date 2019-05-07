package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,Integer>{
}
