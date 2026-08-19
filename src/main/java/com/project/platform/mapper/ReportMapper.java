package com.project.platform.mapper;

import com.project.platform.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    int insert(Report report);
    List<Report> selectAll();
    Report selectById(@Param("id") Integer id);
    int update(Report report);
    List<Report> selectByReporterId(@Param("reporterId") Integer reporterId);
}