package com.gaoxiong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.gaoxiong.pojo.RolePermission;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer>, JpaSpecificationExecutor<RolePermission> {

    List<RolePermission> findAllByRoleId ( Integer roleId );
}