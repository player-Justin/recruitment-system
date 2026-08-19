package com.project.platform.service;

import com.project.platform.entity.InterviewRecord;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 面试记录
 */
public interface InterviewRecordService {

    PageVO<InterviewRecord> page(Map<String, Object> query, Integer pageNum, Integer pageSize);

    InterviewRecord selectById(Integer id);

    List<InterviewRecord> list();

    void insert(InterviewRecord entity);

    void updateById(InterviewRecord entity);

    void removeByIds(List<Integer> id);
}
