package com.memorystudio.photo.domain;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.groupMember.Domain.GroupMember;
import com.memorystudio.letter.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findAllByMonthAndGroupId(String month, Long groupId);
    List<Photo> findAllByMonthAndDateAndGroupId(String month, String date, Long groupId);
    Optional<Photo> findByMonthAndDateAndGroupMember(String month, String date, GroupMember groupMember);

    @Query("select p from Photo p join p.groupMember gm where gm.member.id = ?1")
    List<Photo> findAllByUserId(Long userId);
}
