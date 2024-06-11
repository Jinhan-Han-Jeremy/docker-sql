package com.github.docker_sql.domain.member.dto;


import com.github.docker_sql.domain.member.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {

    private Long id;
    private String username;
    private String name;
    private String nickName;
    private Integer age;
    private Role role;
}