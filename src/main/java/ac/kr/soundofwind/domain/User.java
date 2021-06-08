package ac.kr.soundofwind.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

//ORM: 객체(ORM)를 테이플로 매핑해 줌
@Entity(name = "userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에 연결된 DB의 넘버링 방식을 따른다.
    @Column(name="userId")
    private Integer id; //oracle은 시퀀스, mysql은 auto_increment방식. 이 프로젝트는 mysql의 auto_increment방식을 따름

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private Timestamp createDate;
}
