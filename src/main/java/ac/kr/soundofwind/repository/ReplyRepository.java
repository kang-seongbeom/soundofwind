package ac.kr.soundofwind.repository;

import ac.kr.soundofwind.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Modifying
    @Query(value = "INSERT INTO reply(userinfoId, boardId, content, createDate) VALUE(?1,?2,?3,now())",nativeQuery = true)
    int saveReply(int userId, int boardId, String content);
}
