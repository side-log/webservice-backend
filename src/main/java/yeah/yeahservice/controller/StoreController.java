package yeah.yeahservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yeah.yeahservice.dto.store.GetStoreAndMemberResponse;
import yeah.yeahservice.dto.store.PostStoreAndMemberRequest;
import yeah.yeahservice.service.StoreService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public ResponseEntity<String> saveStoreAndMember(@RequestBody @Valid PostStoreAndMemberRequest request) {
        log.info("[StoreController.saveStoreAndMember]");

        storeService.saveStoreAndMember(request);

        return ResponseEntity.ok("Saved Store And Member");
    }

    @GetMapping("")
    public ResponseEntity<List<GetStoreAndMemberResponse>> getStoreAndMember() {
        log.info("[StoreController.getStoreAndMember]");

        List<GetStoreAndMemberResponse> responseList = storeService.getStoreAndMember();

        return ResponseEntity.ok(responseList);
    }
}