package ac.kr.soundofwind.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "board")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="boardId")
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    @ManyToOne(fetch = FetchType.EAGER) //Many=Board, User=one -> 한명의 유저는 여러개의 게시글(board)를 쓸 수 있다.
    @JoinColumn(name = "userinfo_id")
    private User user; //DB는 오브젝트를 저장 할 수 없다. FK(외래키), 자바는 오브젝트를 저장 할 수 없다.

    // 하나의 게시글은 여러개의 reply를 가질 수 있다.
    //FetchType.EAGER= 즉시로딩, FetchType.LAZY= 지연로딩
    //연관관계 주인이 아니기 때문에(난 FK가 아니다.) mappedBy이기 때문에 DB에 칼럼을 만들지 않는다. join을 통해 reply에서 정보를 가져온다.
    //board는 reply 클래스에서 board와 join할 때 선언된 변수 이름을 적는 것
    //OneToMany의 기본 전략은 LAZY
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)//CascadeType.REMOVE은 게시글 삭제시 댓글삭제
    @JsonIgnoreProperties({"board"}) //무한참조 방지. reply클래스에서 다시 board를 호출하기때문에 무한참조가 발생 할 수 있다.
    @OrderBy("id desc")
    private List<Reply> replys;

    @CreationTimestamp
    private Timestamp createDate;
}
