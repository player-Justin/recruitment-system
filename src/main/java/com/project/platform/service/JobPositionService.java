package com.project.platform.service;

import com.project.platform.entity.JobPosition;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 职位
 */
public interface JobPositionService {

    PageVO<JobPosition> page(Map<String, Object> query, Integer pageNum, Integer pageSize);

    JobPosition selectById(Integer id);

    List<JobPosition> list();

    void insert(JobPosition entity);

    void updateById(JobPosition entity);

    void removeByIds(List<Integer> id);
}
