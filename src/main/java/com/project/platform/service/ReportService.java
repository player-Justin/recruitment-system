package com.project.platform.service;

import com.project.platform.vo.ValueNameVO;

import java.util.List;

public interface ReportService {
    List<ValueNameVO> typeRatio();
    List<ValueNameVO> experienceRequiredRatio();
    List<ValueNameVO> educationRequiredRatio();
    List<ValueNameVO> quantityOfDeliveryCount();
}