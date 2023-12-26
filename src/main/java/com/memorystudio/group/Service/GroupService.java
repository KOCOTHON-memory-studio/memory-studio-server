package com.memorystudio.group.Service;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.group.Domain.GroupRepository;
import com.memorystudio.group.Dto.GroupCreateDTO;
import com.memorystudio.group.Dto.GroupDto;
import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.groupMember.Domain.GroupMemberRepository;
import com.memorystudio.member.domain.Member;
import com.memorystudio.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final GroupMemberRepository groupMemberRepository;

    public GroupDto getGroup(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return GroupDto.builder()
                    .id(optionalGroup.get().getId())
                    .name(optionalGroup.get().getName())
                    .build();
        } else {
            throw new RuntimeException("No Calendar");
        }
    }

    public void addGroup(GroupCreateDTO request) {
        Group group = new Group(request.getGroupName());
        groupRepository.save(group);
        request.getList().stream()
                .forEach(userId ->
                        groupMemberRepository.insertGroupIdAndMemberId(group.getId(), userId));
    }

    public List<Group> getGroups(Long memberId) {
        Member member = memberRepository.findById(memberId)
                        .orElseThrow(IllegalArgumentException::new);

        return groupMemberRepository.findAllByMember(member)
                .stream()
                .map(GroupMember::getGroup)
                .toList();
    }
}
