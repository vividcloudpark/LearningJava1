package hello.spring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import hello.spring.repository.JpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.spring.repository.MemberRepository;
import hello.spring.service.MemberService;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        //  return new JdbcMemberRepository(dataSource);
//        return  new JdbcTemplateMemberRepository(dataSource);
        return  new JpaMemberRepository(em);
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
}
