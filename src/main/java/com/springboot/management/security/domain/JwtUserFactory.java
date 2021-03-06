package com.springboot.management.security.domain;

import com.springboot.management.vo.RoleVO;
import com.springboot.management.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/*
 *@Author 左创源
 * @date 2020/04/18
 *用工厂模式创建JwtUser
 */
public class JwtUserFactory {

    public static JwtUser create(UserVO user){
        return new JwtUser(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getImg(),
                user.getLastPasswordResetDate(),
                user.getStatus()==1?true:false,
                user.getStatus(),
                mapToAuthority(user.getRoles()));
    }

    private static Collection<? extends GrantedAuthority> mapToAuthority(List<RoleVO> authorities){
        return authorities.stream().map(authority ->
                new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
    }
}

