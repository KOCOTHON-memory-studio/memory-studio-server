package com.memorystudio.group.Dto;

import lombok.Data;

@Data
public class GroupResponseDTO {
    private String groupName;
    private Long groupId;
    private Long groupMemberId;

    public GroupResponseDTO(String groupName, Long groupId, Long groupMemberId) {
        this.groupName = groupName;
        this.groupId = groupId;
        this.groupMemberId = groupMemberId;
    }
}
