package com.memorystudio.member.domain;

import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.member.dto.SignupRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String userId;
    private String email;
    private String password;

    public Member(SignupRequestDTO request) {
        this.name = request.getName();
        this.userId = request.getUserId();
        this.email = request.getEmail();
        this.password = request.getPassword1();
    }
}
