package com.memorystudio.photo.Dto;

import com.memorystudio.photo.domain.Photo;
import lombok.Data;

@Data
public class PhotoResponseDTO {
    private String url;
    private String date;


    public PhotoResponseDTO(Photo photo) {
        this.url = photo.getUrl();
        this.date = photo.getDate();
    }
}
