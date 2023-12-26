package com.memorystudio.letter.dto;

import com.memorystudio.letter.domain.Letter;
import lombok.Data;

@Data
public class LetterResponseDTO {
    private String createDate;
    private String username;
    private String content;

    public LetterResponseDTO(Letter letter, String name) {
        this.createDate = letter.getCreateDate();
        this.username = name;
        this.content = letter.getContent();
    }
}
