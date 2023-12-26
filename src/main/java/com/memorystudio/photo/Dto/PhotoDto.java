package com.memorystudio.photo.Dto;

import com.memorystudio.groupMember.Domain.GroupMember;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoDto {
    private Long id;
    private String dir;
    private String date;
    private Long groupMember;
}
