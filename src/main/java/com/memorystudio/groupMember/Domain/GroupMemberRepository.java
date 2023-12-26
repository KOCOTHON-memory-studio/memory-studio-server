package com.memorystudio.groupMember.Domain;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.member.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findAllByGroup(Group group);


    @Transactional
    @Modifying
    @Query("insert into com.memorystudio.groupMember.Domain.GroupMember (group, member) VALUES (?1, ?2)")
    void insertGroupIdAndMemberId(Long groupId, Long memberId);

    List<GroupMember> findAllByMember(Member member);
}
