package hello.spring.repository;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface MemberReposiory {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String Name);
    List <Member> findAll();
    
}
