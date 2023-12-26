package com.memorystudio.member.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member1;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member2;
}
