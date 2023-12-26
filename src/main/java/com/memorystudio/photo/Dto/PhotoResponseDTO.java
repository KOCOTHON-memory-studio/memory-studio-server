package com.memorystudio.photo.Dto;

import com.memorystudio.photo.domain.Photo;
import lombok.Data;

@Data
public class PhotoResponseDTO {
    private String url;

    public PhotoResponseDTO(Photo photo) {
        this.url = photo.getUrl();
    }
}
