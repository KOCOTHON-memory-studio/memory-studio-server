package com.memorystudio.group.Service;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.group.Domain.GroupRepository;
import com.memorystudio.group.Dto.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupService {
    private final GroupRepository groupRepository;

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

    public void addGroup(String name) {
        Group newGroup = new Group();
        newGroup.setName(name);
        groupRepository.save(newGroup);
    }
}
