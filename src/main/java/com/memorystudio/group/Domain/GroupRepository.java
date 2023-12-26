package com.memorystudio.group.Domain;

import com.memorystudio.group.Domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
