package com.memorystudio.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class FriendDto {
    private Long member1;
    private Long member2;
}
