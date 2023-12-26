package com.memorystudio.member;

import com.memorystudio.member.domain.Friend;
import com.memorystudio.member.domain.FriendRepository;
import com.memorystudio.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    public void save(Member member1, Member member2) {
        friendRepository.save(new Friend(member1, member2));
    }

    public List<Friend> getAllFriend() {
        return friendRepository.findAll();
    }
}
