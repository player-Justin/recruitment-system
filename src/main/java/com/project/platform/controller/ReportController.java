package com.project.platform.controller;



import com.project.platform.service.ReportService;
import com.project.platform.vo.ResponseVO;
import com.project.platform.vo.ValueNameVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("typeRatio")
    public ResponseVO<List<ValueNameVO>> typeRatio() {
        return ResponseVO.ok(reportService.typeRatio());
    }

    @GetMapping("experienceRequiredRatio")
    public ResponseVO<List<ValueNameVO>> experienceRequiredRatio() {
        return ResponseVO.ok(reportService.experienceRequiredRatio());
    }

    @GetMapping("educationRequiredRatio")
    public ResponseVO<List<ValueNameVO>> educationRequiredRatio() {
        return ResponseVO.ok(reportService.educationRequiredRatio());
    }

    @GetMapping("quantityOfDeliveryCount")
    public ResponseVO<List<ValueNameVO>> quantityOfDeliveryCount() {
        return ResponseVO.ok(reportService.quantityOfDeliveryCount());
    }


}
