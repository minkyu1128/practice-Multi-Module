package cokr.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_seq")
    @Comment("사용자 Seq(PK)")
    private Long userSeq;
    @Column(name = "username")
    @Comment("사용자 ID")
    private String username;
    @Column(name = "password")
    @Comment("사용자 Password")
    private String password;
    @Column(name = "name")
    @Comment("성명")
    private String name;
    @Column(name = "gender")
    @Comment("성별")
    private String gender;

    // 기본 생성자 (JPA가 사용)
    public UserEntity() {
    }

    // 모든 필드를 초기화하는 생성자
    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
