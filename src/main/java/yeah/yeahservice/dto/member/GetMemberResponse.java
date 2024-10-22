package yeah.yeahservice.dto.member;

import lombok.Data;
import yeah.yeahservice.domain.Member;

@Data
public class GetMemberResponse {
    private String deviceId;
    private String email;

    public GetMemberResponse(Member member) {
        this.deviceId = member.getDeviceId();
        this.email = member.getEmail();
    }
}
