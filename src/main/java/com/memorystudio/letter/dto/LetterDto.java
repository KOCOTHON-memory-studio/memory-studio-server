package com.memorystudio.letter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LetterDto {
    private Long userId;
    private Long friendId;
    private String content;
    private String date;
}
