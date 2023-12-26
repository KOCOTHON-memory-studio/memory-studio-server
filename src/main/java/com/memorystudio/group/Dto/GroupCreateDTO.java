package com.memorystudio.group.Dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupCreateDTO {
    private String groupName;
    private List<Long> list;
}
