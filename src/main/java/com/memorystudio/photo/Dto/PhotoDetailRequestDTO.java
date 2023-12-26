package com.memorystudio.photo.Dto;

import lombok.Data;

@Data
public class PhotoDetailRequestDTO {
    private String month;
    private String date;
    private Long groupId;
}
