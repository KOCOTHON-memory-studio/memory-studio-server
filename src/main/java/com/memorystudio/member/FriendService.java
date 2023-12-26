package com.memorystudio.member;

import com.memorystudio.member.domain.Friend;
import com.memorystudio.member.domain.FriendRepository;
import com.memorystudio.member.domain.Member;
import com.memorystudio.member.domain.MemberRepository;
import com.memorystudio.member.dto.FriendDTO;
import com.memorystudio.member.dto.FriendResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    public void save(FriendDTO friendDto) {
        Member member1 = memberRepository.findById(friendDto.getMember1())
                .orElseThrow(IllegalArgumentException::new);
        Member member2 = memberRepository.findById(friendDto.getMember2())
                .orElseThrow(IllegalArgumentException::new);
        friendRepository.save(new Friend(member1, member2));
        friendRepository.save(new Friend(member2, member1));
    }

    public List<FriendResponseDTO> getFriendList(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(IllegalArgumentException::new);
        return friendRepository.findAllByMember1(member).stream()
                .map(FriendResponseDTO::new)
                .toList();
    }
}
