package yeah.yeahservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeah.yeahservice.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByDeviceId(String deviceId);
}
