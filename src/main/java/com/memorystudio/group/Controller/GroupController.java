package com.memorystudio.group.Controller;

import com.memorystudio.group.Dto.GroupDto;
import com.memorystudio.group.Service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping(value = "/api/group")
    public GroupDto groupInfo(@RequestParam Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping(value = "/api/group")
    public void newGroup(@RequestParam String name){
        groupService.addGroup(name);
    }
}
