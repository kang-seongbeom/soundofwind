package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository  extends JpaRepository<Board, Integer> {

    @Modifying
    @Query(value = "Update  board Set title = ?1 , content = ?2 WHERE boardId= ?3", nativeQuery = true)
    Optional<Integer> update(String title, String content, Integer id);

    Page<Board> findAllByTitleLike(String title, Pageable pageable);

    Page<Board> findAllByContentLike(String content, Pageable pageable);
}
