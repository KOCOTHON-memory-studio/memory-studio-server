package com.memorystudio.groupMember;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.group.Domain.GroupRepository;
import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.groupMember.Domain.GroupMemberRepository;
import com.memorystudio.groupMember.dto.GroupMemberDTO;
import com.memorystudio.member.MemberRepository;
import com.memorystudio.member.domain.Member;
import com.memorystudio.member.dto.MemberIdNameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupMemberService {

    private GroupMemberRepository groupMemberRepository;
    private GroupRepository groupRepository;
    private MemberRepository memberRepository;

    public void save(GroupMemberDTO request) {

        Member member = memberRepository.findById(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        Group group = groupRepository.findById(request.getGroupId())
                .orElseThrow(IllegalArgumentException::new);
        groupMemberRepository.save(new GroupMember(group, member));
    }

    public List<MemberIdNameDTO> findAllByGroupId(Long groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(IllegalArgumentException::new);

        return groupMemberRepository.findAllByGroup(group).stream()
                .map(GroupMember::getMember)
                .map(MemberIdNameDTO::new)
                .toList();
    }
}
