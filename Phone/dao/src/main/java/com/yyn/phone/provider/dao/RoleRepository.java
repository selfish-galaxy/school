package com.yyn.phone.provider.dao;

import com.yyn.phone.provider.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

    @Modifying
    @Transactional
    @Query(value = "select role_menu from role where role_id=?1 ",nativeQuery=true)
    List<Integer> findRoleMenuByRoleId(Integer id);
}
