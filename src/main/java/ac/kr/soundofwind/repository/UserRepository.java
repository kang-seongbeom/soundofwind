package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String Username);

    @Query(value = "select * from userinfo where userId = ?1", nativeQuery = true)
    User getUserpassword(Integer id);

    @Modifying
    @Query(value = "Update  userinfo Set email = ?1 , password = ?2 WHERE userId= ?3", nativeQuery = true)
    Optional<Integer> updateUser(String email, String encPassword, Integer userId);

}
