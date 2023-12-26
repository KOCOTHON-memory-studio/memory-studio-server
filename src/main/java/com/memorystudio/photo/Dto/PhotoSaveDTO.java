package com.memorystudio.photo.Dto;

import lombok.Data;

@Data
public class PhotoSaveDTO {
    private String url;
    private String month;
    private String date;
    private Long groupMemberId;
}
