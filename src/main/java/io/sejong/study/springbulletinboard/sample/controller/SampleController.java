package io.sejong.study.springbulletinboard.sample.controller;

import io.sejong.study.springbulletinboard.sample.entity.Sample;
import io.sejong.study.springbulletinboard.sample.http.req.SampleCreateRequest;
import io.sejong.study.springbulletinboard.sample.http.req.SampleUpdateRequest;
import io.sejong.study.springbulletinboard.sample.model.Type;
import io.sejong.study.springbulletinboard.sample.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /**
     * sample 전체 조회
     * http://localhost:8080/sample/read-all
     */
    @RequestMapping("/sample/read-all")
    public String getSamplesAll(Model model) {
        List<Sample> sampleList = sampleService.getAll();
        model.addAttribute("sampleList", sampleList);

        // sample-read-all.ftl 뷰를 반환한다.
        return "sample-read-all";
    }

    /**
     * sample 단건 조회
     * http://localhost:8080/sample/read-one?sample_id={sample_id}
     */
    @RequestMapping("/sample/read-one")
    public String getSampleOne(Model model, @RequestParam("sample_id") Long sampleId) {
        Sample sample = sampleService.getOneBySampleId(sampleId);
        model.addAttribute("sample", sample);

        // sample-read-one.ftl 뷰를 반환한다.
        return "sample-read-one";
    }

    /**
     * sample 등록
     * http://localhost:8080/sample/create
     */
    @PostMapping("/sample/create")
    public String createSample(Model model, @ModelAttribute SampleCreateRequest request) {
        Sample sample = sampleService.createSample(request);
        model.addAttribute("sample_id", sample.getSampleId());

        // http://localhost:8080/sample/read-one으로 리다이렉션 한다.
        return "redirect:/sample/read-one";
    }

    /**
     * sample 수정
     * http://localhost:8080/sample/update
     */
    @PostMapping("/sample/update")
    public String updateSample(Model model, @ModelAttribute SampleUpdateRequest request) {
        Sample sample = sampleService.updateSample(request);
        model.addAttribute("sample_id", sample.getSampleId());

        // http://localhost:8080/sample/read-one으로 리다이렉션 한다.
        return "redirect:/sample/read-one";
    }

    /**
     * sample 등록/수정 페이지 요청
     * http://localhost:8080/sample/write?type=CREATE
     * http://localhost:8080/sample/write?type=UPDATE&sample_id={sample_id}
     */
    @RequestMapping("/sample/write")
    public String writeSample(
            Model model,
            @RequestParam Type type,
            @RequestParam(value = "sample_id", required = false) Long sampleId
    ) {
        Sample sample;
        if (type == Type.UPDATE) {
            sample = sampleService.getOneBySampleId(sampleId);
            model.addAttribute("sample", sample);
        }
        model.addAttribute("type", type);

        // sample-write.ftl 뷰를 반환한다.
        return "sample-write";
    }

    /**
     * http://localhost:8080/sample/delete?sample_id={sample_id}
     */
    @RequestMapping("/sample/delete")
    public String deleteSample(@RequestParam("sample_id") Long sampleId) {
        sampleService.deleteSample(sampleId);
        // http://localhost:8080/sample/read-all로 리다이렉션 한다.
        return "redirect:/sample/read-all";
    }
}
