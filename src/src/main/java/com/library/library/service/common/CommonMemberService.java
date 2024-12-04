package com.library.library.service.common;

import com.library.library.controller.dto.MemberDto;
import com.library.library.model.Member;
import com.library.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Member create(String firstName, String lastName, String email, OffsetDateTime birthDate) {
        Member newMember = Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .birthDate(birthDate)
                .loans(new HashSet<>())
                .createdDate(OffsetDateTime.now())
                .lastUpdateDate(OffsetDateTime.now())
                .build();

        return repository.save(newMember);
    }

    public MemberDto update(MemberDto memberDto) {
        var member = findById(memberDto.getId())
                .withFirstName(memberDto.getFirstName())
                .withLastName(memberDto.getLastName())
                .withEmail(memberDto.getEmail());

        member.setLastUpdateDate(OffsetDateTime.now());
        repository.save(member);

        return MemberDto.of(findById(member.getId()));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
