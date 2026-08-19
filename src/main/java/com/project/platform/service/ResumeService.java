package com.project.platform.service;

import com.project.platform.entity.Resume;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 简历
 */
public interface ResumeService {

    PageVO<Resume> page(Map<String, Object> query, Integer pageNum, Integer pageSize);

    Resume selectById(Integer id);

    List<Resume> list();

    void insert(Resume entity);

    void updateById(Resume entity);

    void removeByIds(List<Integer> id);
}
