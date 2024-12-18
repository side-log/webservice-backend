package yeah.yeahservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yeah.yeahservice.dto.member.GetMemberResponse;
import yeah.yeahservice.service.MemberService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/email")
    public ResponseEntity<List<GetMemberResponse>> findEmail() {
        log.info("[MemberController.getEmail]");

        List<GetMemberResponse> emailList = memberService.findMember();

        return ResponseEntity.ok(emailList);
    }
}
