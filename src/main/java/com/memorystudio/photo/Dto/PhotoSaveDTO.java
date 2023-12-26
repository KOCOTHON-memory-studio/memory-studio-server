package com.memorystudio.photo.Dto;

import com.memorystudio.photo.domain.Photo;
import lombok.Data;

@Data
public class PhotoSaveDTO {
    private String month;
    private String date;
    private String url;

    public PhotoSaveDTO(Photo photo) {
        this.month = photo.getMonth();
        this.date = photo.getDate();
        this.url = photo.getUrl();
    }
}
