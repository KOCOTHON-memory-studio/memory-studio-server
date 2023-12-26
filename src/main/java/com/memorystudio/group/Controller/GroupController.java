package com.memorystudio.group.Controller;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.group.Dto.GroupCreateDTO;
import com.memorystudio.group.Dto.GroupDto;
import com.memorystudio.group.Dto.GroupResponseDTO;
import com.memorystudio.group.Service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping(value = "/api/group")
    public GroupDto groupInfo(@RequestParam Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping(value = "/api/group")
    public GroupResponseDTO newGroup(@RequestBody GroupCreateDTO request){
        return groupService.addGroup(request);
    }

    @GetMapping("/api/groups")
    public List<GroupResponseDTO> getGroups(@RequestParam Long memberId) {
        return groupService.getGroups(memberId);
    }
}
