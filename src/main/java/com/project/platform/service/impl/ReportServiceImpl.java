package com.project.platform.service.impl;

import com.project.platform.mapper.JobPositionMapper;
import com.project.platform.service.ReportService;
import com.project.platform.vo.ValueNameVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private JobPositionMapper jobPositionMapper;

    /**
     * 全库职位类型分布；SQL 已映射为 name=类型、value=数量（数值），供 ECharts 饼图使用。
     */
    @Override
    public List<ValueNameVO> typeRatio() {
        return jobPositionMapper.typeRatio(null);
    }

    @Override
    public List<ValueNameVO> experienceRequiredRatio() {
        return jobPositionMapper.experienceRequiredRatio(null);
    }

    @Override
    public List<ValueNameVO> educationRequiredRatio() {
        return jobPositionMapper.educationRequiredRatio(null);
    }

    @Override
    public List<ValueNameVO> quantityOfDeliveryCount() {
        return jobPositionMapper.quantityOfDeliveryCount(null);
    }
}
