package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.domain.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WikiRepository extends JpaRepository<Wiki, Integer> {

    @Modifying
    @Query(value = "Update wiki Set title = ?1 , content = ?2 WHERE wikiId= ?3", nativeQuery = true)
    Optional<Integer> update(String title, String content, Integer id);
}
