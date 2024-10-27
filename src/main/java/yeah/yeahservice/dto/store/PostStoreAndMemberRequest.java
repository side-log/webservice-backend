package yeah.yeahservice.dto.store;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostStoreAndMemberRequest {
    @Valid
    @NotNull(message = "Store information is required")
    private StoreDto store;

    @Valid
    @NotNull(message = "User information is required")
    private MemberDto user;
}



