package hello.spring.repository;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberReposiory{
    
    private static Map<Long, Member> store = new HashMap()p<>();
    private static long sequence = 0L;
    
    
    @Override
    public List<Member> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }    


    @Override
    public Optional<Member> findByName(String Name) {
        // TODO Auto-generated method stub
    return Optional.empty();
    }

    @Override
    public Member save(Member member) {
        return null;
    };
}
