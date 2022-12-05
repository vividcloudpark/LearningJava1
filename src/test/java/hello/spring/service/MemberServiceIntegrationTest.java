package hello.spring.service;


import static org.junit.jupiter.api.Assertions.assertThrows;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.spring.domain.Member;
import hello.spring.repository.MemberRepository;

@SpringBootTest
@Transactional //테스트 실행시마다 롤백한다

public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    


    @Test
    void 회원가입() {
        //given 주어진거
        Member member = new Member();
        member.setName("hello");

        //when ~때
        Long savedId = memberService.join(member);

        //then ~해야해
        Member findMember = memberService.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        
    }
}
