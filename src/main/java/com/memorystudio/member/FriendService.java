package com.memorystudio.member;

import com.memorystudio.member.domain.Friend;
import com.memorystudio.member.domain.FriendRepository;
import com.memorystudio.member.domain.Member;
import com.memorystudio.member.domain.MemberRepository;
import com.memorystudio.member.dto.FriendDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    public void save(FriendDto friendDto) {
        Optional<Member> optionalMember1 = memberRepository.findById(friendDto.getMember1());
        Optional<Member> optionalMember2 = memberRepository.findById(friendDto.getMember2());
        if (optionalMember1.isPresent() && optionalMember2.isPresent()) {
            friendRepository.save(new Friend(optionalMember1.get(), optionalMember2.get()));
            friendRepository.save(new Friend(optionalMember2.get(), optionalMember1.get()));
        } else {
            throw new RuntimeException("There's no user");
        }

    }

    public List<Friend> getAllFriend() {
        return friendRepository.findAll();
    }

    public List<FriendDto> getFriendList(Long userId) {
        List<FriendDto> friendDtoList = null;
        List<Friend> allFriend = getAllFriend();
        for (Friend f : allFriend) {
            if (Objects.equals(userId, f.getMember1().getId())) {
                FriendDto tmp = FriendDto.builder()
                        .member1(f.getMember1().getId())
                        .member2(f.getMember2().getId())
                        .build();
                friendDtoList.add(tmp);
            }
        }
        if (friendDtoList == null) {
            throw new RuntimeException("Have no Friend");
        } else {
            return friendDtoList;
        }
    }
}
