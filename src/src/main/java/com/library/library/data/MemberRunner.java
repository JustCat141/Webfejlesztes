package com.library.library.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.library.model.Member;
import com.library.library.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Order(1)
public class MemberRunner implements CommandLineRunner {

    private final MemberRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        InputStream jsonStream = getClass().getResourceAsStream("/data/members.json");
        if (jsonStream == null) {
            throw new IllegalArgumentException("members.json not found!");
        }

        List<Member> members = objectMapper.readValue(jsonStream, new TypeReference<List<Member>>() {});
        members.forEach(member -> member.setLoans(new HashSet<>()));

        repository.saveAll(members);
    }
}