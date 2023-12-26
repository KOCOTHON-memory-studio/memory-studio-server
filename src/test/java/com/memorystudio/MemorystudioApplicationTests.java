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


	@Test
	void friendTest() {
		Member member = Member.builder()
				.email("test@test.com")
				.name("hehe").build();

		Member member2 = Member.builder()
				.email("test2@test.com")
				.name("aaaa").build();

		memberRepository.save(member);
		memberRepository.save(member2);

		friendService.save(member, member2);
		Assertions.assertThat(friendService.getAllFriend()).hasSize(1);
	}
}
