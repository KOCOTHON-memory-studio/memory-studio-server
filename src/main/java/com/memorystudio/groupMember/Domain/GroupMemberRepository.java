package com.memorystudio.groupMember.Domain;

import com.memorystudio.group.Domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findAllByGroup(Group group);
}
