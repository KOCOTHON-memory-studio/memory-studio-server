package com.memorystudio.groupMember.Domain;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.member.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findAllByGroup(Group group);


    @Transactional
    @Modifying
    @Query("INSERT INTO GroupMember gm (gm.group, gm.member) VALUES (:groupId, :memberId)")
    void insertGroupIdAndMemberId(@Param("groupId") Long groupId, @Param("memberId") Long memberId);

    List<GroupMember> findAllByMember(Member member);
}
