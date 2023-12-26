package com.memorystudio.groupMember;


import com.memorystudio.groupMember.dto.GroupMemberDTO;
import com.memorystudio.member.dto.MemberIdNameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupMemberController {

    private GroupMemberService groupMemberService;

    @PostMapping("/api/group_member")
    public void addMapping(@RequestBody GroupMemberDTO request) {
        groupMemberService.save(request);
    }

    @GetMapping("/api/group_member")
    public List<MemberIdNameDTO> getMapping(@RequestParam Long groupId) {
        return groupMemberService.findAllByGroupId(groupId);
    }

}
