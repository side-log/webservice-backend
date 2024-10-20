package yeah.yeahservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeah.yeahservice.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
