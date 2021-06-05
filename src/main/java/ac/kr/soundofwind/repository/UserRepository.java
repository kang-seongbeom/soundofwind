package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
