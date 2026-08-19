package com.project.platform.service.impl;

import com.project.platform.entity.Report;
import com.project.platform.mapper.ReportMapper;
import com.project.platform.service.ReportsMsgService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsMsgServiceImpl implements ReportsMsgService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public int addReport(Report report) {
        return reportMapper.insert(report);
    }

    @Override
    public List<Report> getAllReports() {
        return reportMapper.selectAll();
    }

    @Override
    public Report getReportById(Integer id) {
        return reportMapper.selectById(id);
    }

    @Override
    public int replyReport(Integer id, String reply) {
        Report report = new Report();
        report.setId(id);
        report.setReplyFormAdmin(reply);
        return reportMapper.update(report);
    }

    @Override
    public List<Report> getReportsByReporterId(Integer reporterId) {
        return reportMapper.selectByReporterId(reporterId);
    }
}
