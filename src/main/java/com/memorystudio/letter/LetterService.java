package com.memorystudio.letter;

import com.memorystudio.letter.domain.Letter;
import com.memorystudio.letter.domain.LetterRepository;
import com.memorystudio.letter.dto.LetterDto;
import com.memorystudio.member.domain.Friend;
import com.memorystudio.member.domain.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LetterService {
    private final LetterRepository letterRepository;
    private final FriendRepository friendRepository;

    public LetterDto getLetter(Long letterId) {
        Optional<Letter> optionalLetter = letterRepository.findById(letterId);
        if (optionalLetter.isPresent()) {
            Letter letter = optionalLetter.get();
            return LetterDto.builder()
                    .userId(letter.getId())
                    .date(letter.getDate())
                    .friendId(letter.getFriend().getId())
                    .content(letter.getContent())
                    .build();
        } else {
            throw new RuntimeException("No Letter");
        }
    }

    public void saveLetter(LetterDto letterDto) {
        Optional<Friend> optionalFriend = friendRepository.findById(letterDto.getFriendId());
        if (optionalFriend.isPresent()) {
            Letter newLetter = Letter.builder()
                    .id(letterDto.getUserId())
                    .date(letterDto.getDate())
                    .content(letterDto.getContent())
                    .friend(optionalFriend.get())
                    .build();
            letterRepository.save(newLetter);
        } else {
            throw new RuntimeException("Failed to save Letter (Not a Friend)");
        }

    }
}
