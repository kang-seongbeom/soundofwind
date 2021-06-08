package ac.kr.soundofwind.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="replyId")
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    //한 게시물에는 여러개의 답글이 있을 수 있다.
    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    //한 유저는 여러개의 답글을 달 수 있다.
    @ManyToOne
    @JoinColumn(name="userinfoId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
