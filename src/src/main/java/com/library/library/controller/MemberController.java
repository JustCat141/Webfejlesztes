package com.library.library.controller;

import com.library.library.controller.dto.MemberDto;
import com.library.library.model.Member;
import com.library.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class MemberController {

    private final MemberService memberService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("members")
    public List<MemberDto> findAll() {
        return memberService
                .findAll()
                .stream()
                .map(MemberDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("member/{id}")
    public Member findById(@PathVariable int id) {
        return memberService.findById(id);
    }

    @PostMapping("member/create")
    public void create(@RequestBody MemberDto memberDto) {
        memberService.create(memberDto);
    }

    @PutMapping("member/update")
    public MemberDto update(@RequestBody MemberDto member) {
        return memberService.update(member);
    }

    @DeleteMapping("member/delete/{id}")
    public void delete(@PathVariable int id) {
        memberService.delete(id);
    }
}
