package com.memorystudio.photo.domain;

import com.memorystudio.group.Domain.Group;
import com.memorystudio.groupMember.Domain.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findAllByMonthAndGroupId(String month, Long groupId);
    List<Photo> findAllByMonthAndDateAndGroupId(String month, String date, Long groupId);
    Optional<Photo> findByMonthAndDateAndGroupMember(String month, String date, GroupMember groupMember);

}
