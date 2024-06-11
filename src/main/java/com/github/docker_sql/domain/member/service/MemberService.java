package com.github.docker_sql.domain.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.docker_sql.domain.member.entity.Member;
import com.github.docker_sql.domain.member.repository.MemberRepository;
import com.github.docker_sql.domain.member.dto.MemberDTO;
import com.github.docker_sql.domain.member.dto.MemberCreateDTO;
import com.github.docker_sql.domain.member.dto.MemberUpdateDTO;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> MemberDTO.builder()
                        .id(member.getId())
                        .username(member.getUsername())
                        .name(member.getName())
                        .nickName(member.getNickName())
                        .age(member.getAge())
                        .role(member.getRole())
                        .build())
                .collect(Collectors.toList());
    }

    public MemberDTO getMemberById(Long id) {
        return memberRepository.findById(id)
                .map(member -> MemberDTO.builder()
                        .id(member.getId())
                        .username(member.getUsername())
                        .name(member.getName())
                        .nickName(member.getNickName())
                        .age(member.getAge())
                        .role(member.getRole())
                        .build())
                .orElse(null);
    }

    public MemberDTO saveMember(MemberCreateDTO memberCreateDTO) {
        Member member = Member.builder()
                .username(memberCreateDTO.getUsername())
                .password(memberCreateDTO.getPassword())
                .name(memberCreateDTO.getName())
                .nickName(memberCreateDTO.getNickName())
                .age(memberCreateDTO.getAge())
                .role(memberCreateDTO.getRole())
                .build();
        Member savedMember = memberRepository.save(member);
        return MemberDTO.builder()
                .id(savedMember.getId())
                .username(savedMember.getUsername())
                .name(savedMember.getName())
                .nickName(savedMember.getNickName())
                .age(savedMember.getAge())
                .role(savedMember.getRole())
                .build();
    }

    public MemberDTO updateMember(Long id, MemberUpdateDTO memberUpdateDTO) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.setUsername(memberUpdateDTO.getUsername());
        member.setPassword(memberUpdateDTO.getPassword());
        member.setName(memberUpdateDTO.getName());
        member.setNickName(memberUpdateDTO.getNickName());
        member.setAge(memberUpdateDTO.getAge());
        member.setRole(memberUpdateDTO.getRole());
        Member updatedMember = memberRepository.save(member);
        return MemberDTO.builder()
                .id(updatedMember.getId())
                .username(updatedMember.getUsername())
                .name(updatedMember.getName())
                .nickName(updatedMember.getNickName())
                .age(updatedMember.getAge())
                .role(updatedMember.getRole())
                .build();
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}