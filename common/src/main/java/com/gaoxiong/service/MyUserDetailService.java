package com.gaoxiong.service;

import com.gaoxiong.pojo.*;
import com.gaoxiong.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gaoxiong
 * @ClassName MyUserDetailService
 * @Description TODO
 * @date 2019/6/27 14:10
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MemberRoleRepository memberRoleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        Member memberName = memberRepository.findByMemberName(username);
        if (memberName == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;
        List<MemberRole> memberRoleList = memberRoleRepository.findAllByMemberId(memberName.getId());
        for (MemberRole memberRole : memberRoleList) {
            Role role = roleRepository.findById(memberRole.getRoleId()).get();
            String roleName = role.getRoleName();
            //角色必须是ROLE_开头,可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
            grantedAuthorities.add(grantedAuthority);
            //获取权限
            List<RolePermission> rolePermissionList = rolePermissionRepository.findAllByRoleId(role.getId());
            List<Permission> permissions = permissionRepository.findAllByIdIn(rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toList()));
            grantedAuthorities.addAll(permissions.stream().map(e -> new SimpleGrantedAuthority(e.getUri())).collect(Collectors.toList()));
        }

        User user = new User(memberName.getMemberName(), memberName.getPassword(), grantedAuthorities);
        return user;
    }
}
