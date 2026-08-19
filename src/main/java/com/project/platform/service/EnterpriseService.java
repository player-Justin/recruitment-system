package com.project.platform.service;

import com.project.platform.entity.Enterprise;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 企业
 */
public interface EnterpriseService extends CommonService {

    PageVO<Enterprise> page(Map<String, Object> query, Integer pageNum, Integer pageSize);

    Enterprise selectById(Integer id);

    List<Enterprise> list();

    void insert(Enterprise entity);

    void updateById(Enterprise entity);

    void removeByIds(List<Integer> id);
}
