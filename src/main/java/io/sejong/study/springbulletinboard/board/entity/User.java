package io.sejong.study.springbulletinboard.board.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.apache.tomcat.util.security.MD5Encoder;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id", length=20, nullable=false)
    private String id;

    @Column(length=20, nullable=false)
    private String nickname;

    @Column(nullable=false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    // N:1 관계 매핑
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id")
    private List<Board> boards;

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
