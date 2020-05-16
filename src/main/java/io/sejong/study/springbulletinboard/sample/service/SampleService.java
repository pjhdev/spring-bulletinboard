package io.sejong.study.springbulletinboard.sample.service;

import io.sejong.study.springbulletinboard.sample.entity.Sample;
import io.sejong.study.springbulletinboard.sample.http.req.SampleCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.SampleUpdateRequest;
import io.sejong.study.springbulletinboard.sample.repository.SampleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

  private final SampleRepository sampleRepository;

  /** 생성자 의존관계 주입(DI, AOP 알아보기) 이외에도 @Autowired를 이용한 필드주입, setter 주입이 있다. */
  public SampleService(SampleRepository sampleRepository) {
    this.sampleRepository = sampleRepository;
  }

  public List<Sample> getAll() {
    return sampleRepository.findAll();
  }

  public Sample getOneBySampleId(Long sampleId) {
    return sampleRepository.findBySampleId(sampleId);
  }

  public Sample createSample(SampleCreateRequest request) {
    Sample sample =
        new Sample(
            request.getName(), request.getAge(), request.getBirthday(), request.getAddress());

    return sampleRepository.save(sample);
  }

  public Sample updateSample(SampleUpdateRequest request) {
    Sample sample = sampleRepository.findBySampleId(request.getSampleId());
    sample.setName(request.getName());
    sample.setAge(request.getAge());
    sample.setBirthday(request.getBirthday());
    sample.setAddress(request.getAddress());

    return sampleRepository.save(sample);
  }

  public void deleteSample(Long sampleId) {
    sampleRepository.deleteById(sampleId);
  }
}
