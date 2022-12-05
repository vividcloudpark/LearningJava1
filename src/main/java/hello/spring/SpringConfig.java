package hello.spring;

import javax.sql.DataSource;

import hello.spring.repository.JdbcTemplateMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.spring.repository.JdbcMemberRepository;
import hello.spring.repository.MemberRepository;
import hello.spring.service.MemberService;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    
    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        //  return new JdbcMemberRepository(dataSource);
        return  new JdbcTemplateMemberRepository(dataSource);
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
}
