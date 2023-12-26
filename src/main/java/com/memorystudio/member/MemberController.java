package com.memorystudio.member;

import com.memorystudio.member.dto.LoginRequestDTO;
import com.memorystudio.member.dto.MemberIdNameDTO;
import com.memorystudio.member.dto.SignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/member")
    public MemberIdNameDTO getMember(@RequestParam Long userId) {
        return null;
    }

    @PostMapping("/api/login")
    public MemberIdNameDTO login(@RequestBody LoginRequestDTO request) {
        return memberService.login(request);
    }

    @PostMapping("/api/signup")
    public MemberIdNameDTO signup(@RequestBody SignupRequestDTO request) {
        return memberService.signup(request);
    }
}
