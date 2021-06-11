package ac.kr.soundofwind.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "wiki")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wiki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wikiId")
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    @ManyToOne(fetch = FetchType.EAGER) //Many=Board, User=one -> 한명의 유저는 여러개의 게시글(board)를 쓸 수 있다.
    @JoinColumn(name = "userinfo_id")
    private User user; //DB는 오브젝트를 저장 할 수 없다. FK(외래키), 자바는 오브젝트를 저장 할 수 없다.

    @CreationTimestamp
    private Timestamp createDate;
}
