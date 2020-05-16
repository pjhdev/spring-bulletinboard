package io.sejong.study.springbulletinboard.sample.http.req;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SampleUpdateRequest {
    private Long sampleId;
    private String name;
    private Integer age;
    private LocalDateTime birthday;
    private String address;
}
