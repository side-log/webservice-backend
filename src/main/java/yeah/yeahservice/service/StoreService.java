package yeah.yeahservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yeah.yeahservice.domain.Member;
import yeah.yeahservice.domain.Store;
import yeah.yeahservice.dto.store.GetStoreAndMemberResponse;
import yeah.yeahservice.dto.store.MemberDto;
import yeah.yeahservice.dto.store.PostStoreAndMemberRequest;
import yeah.yeahservice.dto.store.StoreDto;
import yeah.yeahservice.repository.MemberRepository;
import yeah.yeahservice.repository.StoreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void saveStoreAndMember(PostStoreAndMemberRequest request) {
        log.info("[StoreService.saveStoreAndMember]");

        Member findMember = memberRepository.findByDeviceId(request.getUser().getDeviceId())
                .orElseGet(() -> {
                    Member member = new Member();

                    member.setDeviceId(request.getUser().getDeviceId());
                    member.setEmail(request.getUser().getEmail());
                    return memberRepository.save(member);
                });

        Store store = new Store();

        store.setMember(findMember);
        store.setType(request.getStore().getType());
        store.setLocation(request.getStore().getLocation());
        store.setBestMenu(request.getStore().getBestMenu());
        store.setPrice(request.getStore().getPrice());
        store.setTarget(request.getStore().getTarget());
        store.setMood(request.getStore().getMood());

        storeRepository.save(store);
    }

    public List<GetStoreAndMemberResponse> getStoreAndMember() {
        log.info("[StoreService.getStoreAndMember]");

        List<Store> stores = storeRepository.findAll();

        return stores.stream()
                .map(store -> {
                    GetStoreAndMemberResponse response = new GetStoreAndMemberResponse();

                    // Store -> StoreDto
                    StoreDto storeDto = new StoreDto();
                    storeDto.setType(store.getType());
                    storeDto.setLocation(store.getLocation());
                    storeDto.setBestMenu(store.getBestMenu());
                    storeDto.setPrice(store.getPrice());
                    storeDto.setTarget(store.getTarget());
                    storeDto.setMood(store.getMood());

                    // Member -> MemberDto
                    MemberDto memberDto = new MemberDto();
                    memberDto.setEmail(store.getMember().getEmail());
                    memberDto.setDeviceId(store.getMember().getDeviceId());

                    // Set DTOs to response
                    response.setStore(storeDto);
                    response.setMember(memberDto);

                    return response;
                })
                .collect(Collectors.toList());
    }
}
