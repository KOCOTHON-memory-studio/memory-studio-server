package com.memorystudio.letter.domain;


import com.memorystudio.letter.dto.LetterDto;
import com.memorystudio.member.domain.Friend;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    Friend friend;

    String content;
    String createDate;
    String openDate;

    public Letter(LetterDto letterDto, Friend friend) {
        this.content = letterDto.getContent();
        this.createDate = letterDto.getCreateDate();
        this.openDate = letterDto.getOpenDate();
        this.friend = friend;
    }
}
