package yeah.yeahservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String location;
    private String bestMenu;
    private String price;
    private String target;
    private String mood;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
