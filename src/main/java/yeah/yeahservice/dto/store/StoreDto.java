package yeah.yeahservice.dto.store;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreDto {
    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Best menu is required")
    private String bestMenu;

    @NotBlank(message = "Price is required")
    private String price;

    @NotBlank(message = "Target is required")
    private String target;

    @NotBlank(message = "Mood is required")
    private String mood;
}