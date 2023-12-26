package com.memorystudio.letter;

import com.memorystudio.letter.domain.Letter;
import com.memorystudio.letter.domain.LetterRepository;
import com.memorystudio.letter.dto.LetterDto;
import com.memorystudio.letter.dto.LetterResponseDTO;
import com.memorystudio.member.domain.Friend;
import com.memorystudio.member.domain.FriendRepository;
import com.memorystudio.member.domain.Member;
import com.memorystudio.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    public LetterResponseDTO getLetter(Long letterId) {
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(IllegalArgumentException::new);
        return new LetterResponseDTO(letter, letter.getFriend().getMember2().getName());

    }

    public void saveLetter(LetterDto letterDto) {
        Member member1 = memberRepository.findById(letterDto.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        Member member2 = memberRepository.findByName(letterDto.getFriendName())
                .orElseThrow(IllegalArgumentException::new);

        Friend friend = friendRepository.findByMember1AndMember2(member1, member2)
                .orElseThrow(IllegalArgumentException::new);

        Letter letter = new Letter(letterDto, friend);
        letterRepository.save(letter);
    }
}
