package yeah.yeahservice.dto.store;

import lombok.Data;

@Data
public class GetStoreAndMemberResponse {

    private StoreDto store;
    private MemberDto member;
}
