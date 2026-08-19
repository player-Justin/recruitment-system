package com.project.platform.service;

import com.project.platform.entity.ApplicationRecord;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 投递记录
 */
public interface ApplicationRecordService {

    PageVO<ApplicationRecord> page(Map<String, Object> query, Integer pageNum, Integer pageSize);

    ApplicationRecord selectById(Integer id);

    List<ApplicationRecord> list();

    void insert(ApplicationRecord entity);

    void updateById(ApplicationRecord entity);

    void removeByIds(List<Integer> id);
}
