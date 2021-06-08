package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String Username);

    @Modifying
    @Query(value = "Update  userinfo Set email = ?1 , password = ?2 WHERE userId= ?3", nativeQuery = true)
    Optional<Integer> updateUser(String email, String encPassword, Integer userId);
}
