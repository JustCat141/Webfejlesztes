package com.library.library.controller;

import com.library.library.controller.dto.MemberDto;
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

    @PostMapping("member/create")
    public void create(@RequestBody MemberDto memberDto) {

        memberService.create(memberDto);
    }
}
