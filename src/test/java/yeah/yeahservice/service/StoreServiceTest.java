package yeah.yeahservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yeah.yeahservice.domain.Member;
import yeah.yeahservice.dto.store.MemberDto;
import yeah.yeahservice.dto.store.PostStoreAndMemberRequest;
import yeah.yeahservice.dto.store.StoreDto;
import yeah.yeahservice.repository.MemberRepository;
import yeah.yeahservice.repository.StoreRepository;

@Transactional
@SpringBootTest
class StoreServiceTest {

    @Autowired
    StoreService storeService;
    @Autowired
    MemberService memberService;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 멤버_존재_가게_저장() throws Exception {
        //given
        PostStoreAndMemberRequest request = createTestRequest();

        Member existMember = new Member();
        existMember.setDeviceId(request.getUser().getDeviceId());
        existMember.setEmail(request.getUser().getEmail());
        memberRepository.save(existMember);

        //when
        storeService.saveStoreAndMember(request);
        
        //then
        Member findMember = memberRepository.findById(request.getUser().getDeviceId()).orElseThrow();
        Assertions.assertEquals(findMember.getDeviceId(), existMember.getDeviceId());
    }

    private PostStoreAndMemberRequest createTestRequest() {
        StoreDto storeDto = new StoreDto();
        storeDto.setType("Restaurant");
        storeDto.setLocation("123 Main St");
        storeDto.setBestMenu("Pizza");
        storeDto.setPrice("Medium");
        storeDto.setTarget("Families");
        storeDto.setMood("Cozy");

        MemberDto memberDto = new MemberDto();
        memberDto.setEmail("test@example.com");
        memberDto.setDeviceId("device123");

        PostStoreAndMemberRequest request = new PostStoreAndMemberRequest();
        request.setStore(storeDto);
        request.setUser(memberDto);

        return request;
    }
}