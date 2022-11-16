package hello.spring.repository;

import java.util.List;

import org.assertj.core.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import hello.spring.domain.Member;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository  = new MemoryMemberRepository();
    // 하나의 테스트가 끝날때마다 공용변수는 없애야한다. 왜냐하면 메모리에는 자꾸 남아있으니까

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findByName("spring").get();
        // Assertions.assertEquals(member, member);

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(member1).isEqualTo(result);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List <Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}
