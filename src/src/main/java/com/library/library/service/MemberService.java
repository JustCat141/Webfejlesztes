package com.library.library.service;

import com.library.library.model.Loan;
import com.library.library.model.Member;
import com.library.library.service.common.CommonBookService;
import com.library.library.service.common.CommonLoanService;
import com.library.library.service.common.CommonMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final CommonMemberService memberService;
    private final CommonLoanService loanService;
    private final CommonBookService bookService;

    public Member findById(int id) {
        return memberService.findById(id);
    }

    public Member update(Member member) {
        return memberService.update(member);
    }

    public void delete(Member member) throws OperationNotSupportedException {

        if (!member.getLoans().isEmpty()) {
            throw new OperationNotSupportedException("Cannot delete member with active loans");
        }

        member.getLoans().forEach(loanService::delete);
        memberService.delete(member);
    }

    public List<Loan> getMemberLoans(Member member) {
        return member.getLoans().stream().toList();
    }
}
