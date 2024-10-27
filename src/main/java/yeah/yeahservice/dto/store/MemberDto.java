package yeah.yeahservice.dto.store;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberDto {
    @NotBlank(message = "Device ID is required")
    private String deviceId;

    @NotBlank(message = "Email is required")
    private String email;
}