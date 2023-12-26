package com.memorystudio.member.dto;

import com.memorystudio.member.domain.Friend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
@AllArgsConstructor
public class FriendResponseDTO {
    private String username;

    public FriendResponseDTO(Friend friend) {
        this.username = friend.getMember2().getName();
    }
}
