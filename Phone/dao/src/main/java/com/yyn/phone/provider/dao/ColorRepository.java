package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Color;
import com.yyn.phone.provider.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,Integer>{
}
