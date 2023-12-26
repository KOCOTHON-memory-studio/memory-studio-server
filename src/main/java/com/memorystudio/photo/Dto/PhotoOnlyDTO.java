package com.memorystudio.photo.Dto;

import com.memorystudio.photo.domain.Photo;
import lombok.Data;

@Data
public class PhotoOnlyDTO {
    private String url;

    public PhotoOnlyDTO(Photo photo) {
        this.url = photo.getUrl();
    }
}
