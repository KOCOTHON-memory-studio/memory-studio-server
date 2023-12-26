package com.memorystudio.member;

import com.memorystudio.member.dto.FriendDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/api/friend")
    public void addFriend(@RequestBody FriendDto friendDto) {
        friendService.save(friendDto);
    }

    @GetMapping("/api/friend")
    public List<FriendDto> getFriendList(@RequestParam Long userId) {
        return friendService.getFriendList(userId);
    }
}
