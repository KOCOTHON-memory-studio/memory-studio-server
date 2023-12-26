package com.memorystudio.letter.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {

    @Query("select l from Letter l join l.friend f where f.member2.id = ?1")
    List<Letter> findAllByUserId(Long userId);
}
