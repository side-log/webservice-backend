package yeah.yeahservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeah.yeahservice.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
