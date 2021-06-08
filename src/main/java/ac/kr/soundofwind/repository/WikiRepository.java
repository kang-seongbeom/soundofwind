package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.domain.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<Wiki, Integer> {
}
