package com.library.library.controller.dto;

import com.library.library.model.Member;
import lombok.Data;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
public class MemberDto {
    int id;
    String firstName;
    String lastName;
    String email;
    OffsetDateTime birthDate;

    OffsetDateTime createdDate;
    OffsetDateTime lastUpdateDate;

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .birthDate(member.getBirthDate())
                .createdDate(member.getCreatedDate())
                .lastUpdateDate(member.getCreatedDate())
                .build();
    }
}