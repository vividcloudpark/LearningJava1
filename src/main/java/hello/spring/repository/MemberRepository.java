package hello.spring.repository;
import hello.spring.domain.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

// @Repository
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}