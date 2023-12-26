package com.memorystudio.photo.Dto;

import com.memorystudio.photo.domain.Photo;
import lombok.Data;

@Data
public class PhotoDetailResponseDTO {
    private String username;
    private String url;

    public PhotoDetailResponseDTO(Photo photo) {
        this.username = photo.getGroupMember().getMember().getName();
        this.url = photo.getUrl();
    }
}
