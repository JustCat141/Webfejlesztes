package com.library.library.service;

import com.library.library.controller.dto.MemberDto;
import com.library.library.model.Loan;
import com.library.library.model.Member;
import com.library.library.service.common.CommonBookService;
import com.library.library.service.common.CommonLoanService;
import com.library.library.service.common.CommonMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final CommonMemberService memberService;
    private final CommonLoanService loanService;
    private final CommonBookService bookService;

    public List<Member> findAll() {
        return memberService.findAll();
    }

    public Member create(MemberDto memberDto) {
        return memberService.create(
                memberDto.getFirstName(),
                memberDto.getLastName(),
                memberDto.getEmail(),
                memberDto.getBirthDate()
        );
    }

    public Member findById(int id) {
        return memberService.findById(id);
    }

    public MemberDto update(MemberDto member) {
        return memberService.update(member);
    }

    public void delete(int id) {

        var member = memberService.findById(id);

        if (!member.getLoans().isEmpty()) {
            throw new RuntimeException("Cannot delete member with active loans");
        }

        member.getLoans().forEach(
                loan -> loanService.delete(loan.getId())
        );
        memberService.delete(id);
    }

    public List<Loan> getMemberLoans(Member member) {
        return member.getLoans().stream().toList();
    }
}
