package com.memorystudio.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByMember1(Member member);

    Optional<Friend> findByMember1AndMember2(Member member1, Member member2);
}
