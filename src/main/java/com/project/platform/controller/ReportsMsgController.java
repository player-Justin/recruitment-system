package com.project.platform.controller;

import com.project.platform.entity.Report;
import com.project.platform.service.ReportsMsgService;
import com.project.platform.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportsMsg")
public class ReportsMsgController {

    @Resource
    private ReportsMsgService reportsMsgService;

    @PostMapping("/add")
    public ResponseVO<?> addReport(@RequestBody Report report) {
        int result = reportsMsgService.addReport(report);
        if (result > 0) {
            return ResponseVO.ok(null);
        } else {
            return ResponseVO.fail(500, null);
        }
    }

    @GetMapping("/list")
    public ResponseVO<List<Report>> getAllReports() {
        List<Report> reports = reportsMsgService.getAllReports();
        return ResponseVO.ok(reports);
    }

    @PostMapping("/reply")
    public ResponseVO<?> replyReport(@RequestParam Integer id, @RequestParam String reply) {
        int result = reportsMsgService.replyReport(id, reply);
        if (result > 0) {
            return ResponseVO.ok(null);
        } else {
            return ResponseVO.fail(500, null);
        }
    }

    @GetMapping("/user/list")
    public ResponseVO<List<Report>> getUserReports(@RequestParam Integer userId) {
        List<Report> reports = reportsMsgService.getReportsByReporterId(userId);
        return ResponseVO.ok(reports);
    }

    @GetMapping("/detail")
    public ResponseVO<Report> getReportDetail(@RequestParam Integer id) {
        Report report = reportsMsgService.getReportById(id);
        return ResponseVO.ok(report);
    }
}
