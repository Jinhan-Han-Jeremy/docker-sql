package com.github.docker_sql.domain.member.dto;


import com.github.docker_sql.domain.member.entity.Role;
import lombok.Data;

@Data
public class MemberCreateDTO {
    private String username;
    private String password;
    private String name;
    private String nickName;
    private Integer age;
    private Role role;
}