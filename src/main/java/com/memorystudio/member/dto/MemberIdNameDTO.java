package com.memorystudio.member.dto;

import com.memorystudio.member.domain.Member;
import lombok.Data;

@Data
public class MemberIdNameDTO {
    private Long id;
    private String name;

    public MemberIdNameDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
