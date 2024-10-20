package yeah.yeahservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yeah.yeahservice.domain.Member;
import yeah.yeahservice.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public List<String> findEmail() {
        List<Member> members = memberRepository.findAll();

        List<String> emails = new ArrayList<>();
        for (Member member : members) {
            emails.add(member.getEmail());
        }

        return emails;
    }
}
