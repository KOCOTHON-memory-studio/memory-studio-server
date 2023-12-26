package com.memorystudio.member;

import com.memorystudio.member.domain.Member;
import com.memorystudio.member.domain.MemberRepository;
import com.memorystudio.member.dto.LoginRequestDTO;
import com.memorystudio.member.dto.MemberIdNameDTO;
import com.memorystudio.member.dto.SignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberIdNameDTO signup(SignupRequestDTO request) {
        String password1 = request.getPassword1();
        String password2 = request.getPassword2();
        if(!password1.equals(password2)) {
            throw new RuntimeException("비밀번호가 서로 일치하지 않습니다.");
        }

        if(memberRepository.existsMemberByUserId(request.getUserId())) {
            throw new RuntimeException("사용할 수 없는 아이디입니다.");
        }
        if (memberRepository.existsMemberByEmail(request.getEmail())) {
            throw new RuntimeException("사용할 수 없는 이메일입니다.");
        }

        return new MemberIdNameDTO(memberRepository.save(new Member(request)));
    }

    public MemberIdNameDTO login(LoginRequestDTO request) {
        Member member = memberRepository.findByUserId(request.getUserId());

        if(!member.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return new MemberIdNameDTO(member);
    }
}
