package com.gaoxiong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.gaoxiong.pojo.Permission;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Integer>, JpaSpecificationExecutor<Permission> {

    List<Permission> findAllByIdIn (List<Integer> ids);
}