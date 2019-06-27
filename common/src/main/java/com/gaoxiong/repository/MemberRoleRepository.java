package com.gaoxiong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.gaoxiong.pojo.MemberRole;

import java.util.List;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer>, JpaSpecificationExecutor<MemberRole> {

    List<MemberRole> findAllByMemberId ( Integer memberId );
}