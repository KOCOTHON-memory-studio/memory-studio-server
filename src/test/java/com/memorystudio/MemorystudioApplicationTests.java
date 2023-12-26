package com.memorystudio;

import com.memorystudio.member.FriendService;
import com.memorystudio.member.domain.Member;
import com.memorystudio.member.domain.MemberRepository;
import org.aspectj.lang.annotation.RequiredTypes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.Source;

@SpringBootTest
class MemorystudioApplicationTests {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	FriendService friendService;

	@Test
	void contextLoads() {
	}


}
