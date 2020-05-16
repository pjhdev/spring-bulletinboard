package io.sejong.study.springbulletinboard.sample.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sample {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sampleId;

  private String name;
  private Integer age;
  private LocalDateTime birthday;
  private String address;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updatedAt;

  public Sample(String name, Integer age, LocalDateTime birthday, String address) {
    this.name = name;
    this.age = age;
    this.birthday = birthday;
    this.address = address;
  }
}
