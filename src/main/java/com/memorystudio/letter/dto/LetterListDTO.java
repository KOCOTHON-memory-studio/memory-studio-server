package com.memorystudio.letter.dto;

import com.memorystudio.letter.domain.Letter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LetterListDTO {
    private String username;
    private String friendName;
    private String content;
    private String createDate;
    private String openDate;

    public LetterListDTO(Letter l) {
        this.username = l.getFriend().getMember1().getName();
        this.friendName = l.getFriend().getMember2().getName();
        this.content = l.getContent();
        this.createDate = l.getCreateDate();
        this.openDate = l.getOpenDate();
    }
}
