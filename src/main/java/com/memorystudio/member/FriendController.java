package com.memorystudio.member;

import com.memorystudio.member.dto.FriendDTO;
import com.memorystudio.member.dto.FriendResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/api/friend")
    public void addFriend(@RequestBody FriendDTO friendDto) {
        friendService.save(friendDto);
    }

    @GetMapping("/api/friend")
    public List<FriendResponseDTO> getFriendList(@RequestParam Long userId) {
        return friendService.getFriendList(userId);
    }
}
