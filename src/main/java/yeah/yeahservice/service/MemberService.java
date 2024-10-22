package yeah.yeahservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yeah.yeahservice.domain.Member;
import yeah.yeahservice.dto.member.GetMemberResponse;
import yeah.yeahservice.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public List<GetMemberResponse> findMember() {
        log.info("[MemberService.findMember]");

        List<Member> members = memberRepository.findAll();

        return members.stream()
                .map(GetMemberResponse::new)
                .collect(Collectors.toList());
    }
}
