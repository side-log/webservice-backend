package yeah.yeahservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yeah.yeahservice.domain.Member;
import yeah.yeahservice.domain.Store;
import yeah.yeahservice.dto.PostStoreAndMemberRequest;
import yeah.yeahservice.repository.MemberRepository;
import yeah.yeahservice.repository.StoreRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void saveStoreAndMember(PostStoreAndMemberRequest request) {
        log.info("[StoreService.saveStroeAndMember]");

        Member member = new Member();
        Store store = new Store();

        member.setDeviceId(request.getUser().getDeviceId());
        member.setEmail(request.getUser().getEmail());

        Member saveMember = memberRepository.save(member);

        store.setMember(saveMember);
        store.setType(request.getStore().getType());
        store.setLocation(request.getStore().getLocation());
        store.setBestMenu(request.getStore().getBestMenu());
        store.setPrice(request.getStore().getPrice());
        store.setTarget(request.getStore().getTarget());
        store.setMood(request.getStore().getMood());

        storeRepository.save(store);
    }
}
