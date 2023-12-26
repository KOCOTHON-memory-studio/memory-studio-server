package com.memorystudio.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsMemberByUserId(String userId);
    boolean existsMemberByEmail(String email);
    Member findByUserId(String userId);

    Optional<Member> findByName(String friendName);
}
