package com.memorystudio.letter.domain;


import com.memorystudio.member.domain.Friend;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    Friend friend;

    String content;
    String date;
}
