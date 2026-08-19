package com.project.platform.service;

import com.project.platform.entity.Report;

import java.util.List;

public interface ReportsMsgService {
    int addReport(Report report);
    List<Report> getAllReports();
    Report getReportById(Integer id);
    int replyReport(Integer id, String reply);
    List<Report> getReportsByReporterId(Integer reporterId);
}