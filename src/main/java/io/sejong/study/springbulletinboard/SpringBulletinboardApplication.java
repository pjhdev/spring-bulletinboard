package io.sejong.study.springbulletinboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.Charset;

@SpringBootApplication
public class SpringBulletinboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBulletinboardApplication.class, args);
  }
}
