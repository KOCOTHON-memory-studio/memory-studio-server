package com.memorystudio.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsMemberByUserId(String userId);
    boolean existsMemberByEmail(String email);
    Member findByUserId(String userId);
}
