package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{
}
