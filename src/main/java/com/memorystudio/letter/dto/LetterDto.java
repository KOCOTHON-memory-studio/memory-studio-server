package com.memorystudio.letter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LetterDto {
    private Long userId;
    private String friendName;
    private String content;
    private String createDate;
    private String openDate;
}
