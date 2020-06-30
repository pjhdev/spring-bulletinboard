package io.sejong.study.springbulletinboard.board.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;
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
}
