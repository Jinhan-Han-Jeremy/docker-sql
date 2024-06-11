package com.github.docker_sql.domain.member.controller;

import java.util.List;

import com.github.docker_sql.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.docker_sql.domain.member.dto.MemberDTO;
import com.github.docker_sql.domain.member.dto.MemberCreateDTO;
import com.github.docker_sql.domain.member.dto.MemberUpdateDTO;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id) {
        MemberDTO member = memberService.getMemberById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public MemberDTO createMember(@RequestBody MemberCreateDTO memberCreateDTO) {
        return memberService.saveMember(memberCreateDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Long id, @RequestBody MemberUpdateDTO memberUpdateDTO) {
        MemberDTO member = memberService.updateMember(id, memberUpdateDTO);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}