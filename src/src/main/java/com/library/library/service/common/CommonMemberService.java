package com.library.library.service.common;

import com.library.library.model.Member;
import com.library.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonMemberService implements CommonService<Member> {

    private final MemberRepository repository;

    @Override
    public List<Member> findAll() {
        return repository.findAll();
    }

    @Override
    public Member findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find library member!"));
    }

    public void create(String firstName, String lastName, String email, OffsetDateTime birthDate) {
        Member newMember = Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .birthDate(birthDate)
                .loans(new HashSet<>())
                .createdDate(OffsetDateTime.now())
                .lastUpdateDate(OffsetDateTime.now())
                .build();

        repository.save(newMember);
    }

    @Override
    public Member update(Member member) {
        member.setLastUpdateDate(OffsetDateTime.now());
        return repository.save(member);
    }

    @Override
    public void delete(Member member) {
        repository.deleteById(member.getId());
    }
}
