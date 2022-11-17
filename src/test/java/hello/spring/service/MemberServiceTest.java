package hello.spring.service;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.spring.domain.Member;
import hello.spring.repository.MemoryMemberRepository;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;
    private Optional<Member> findOne;
    
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        //이런것이 바로 Di (Depency Injection)
    }
    
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void testFindMembers() {


    }

    @Test
    void testFindOne() {

    }

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

        // try{
        //     memberService.join(member2);
        //     Fail();
        // }catch (IllegalStateException e){
        //     Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재합니다");
        // }
        //then

        
    }
}
