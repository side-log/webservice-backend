package yeah.yeahservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yeah.yeahservice.dto.PostStoreAndMemberRequest;
import yeah.yeahservice.service.StoreService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public ResponseEntity<String> saveStoreAndMember(@RequestBody PostStoreAndMemberRequest request) {
        log.info("[StoreController.saveStoreAndMember]");

        storeService.saveStoreAndMember(request);

        return ResponseEntity.ok("Saved Store And Member");
    }
}
