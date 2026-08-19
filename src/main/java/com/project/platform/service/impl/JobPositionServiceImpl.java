package com.project.platform.service.impl;

import com.project.platform.dto.CurrentUserDTO;
import com.project.platform.entity.Enterprise;
import com.project.platform.entity.JobPosition;
import com.project.platform.exception.CustomException;
import com.project.platform.mapper.EnterpriseMapper;
import com.project.platform.mapper.JobPositionMapper;
import com.project.platform.service.JobPositionService;
import com.project.platform.utils.CurrentUserThreadLocal;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 职位
 */
@Service
public class JobPositionServiceImpl implements JobPositionService {
    @Resource
    private JobPositionMapper jobPositionMapper;
    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public PageVO<JobPosition> page(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        PageVO<JobPosition> page = new PageVO();
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (currentUserDTO.isEnterprise()) {
            query.put("enterpriseId", currentUserDTO.getId());
        }

        List<JobPosition> list = jobPositionMapper.queryPage((pageNum - 1) * pageSize, pageSize, query);
        page.setList(list);
        page.setTotal(jobPositionMapper.queryCount(query));
        return page;
    }

    @Override
    public JobPosition selectById(Integer id) {
        JobPosition jobPosition = jobPositionMapper.selectById(id);
        return jobPosition;
    }

    @Override
    public List<JobPosition> list() {
        return jobPositionMapper.list();
    }

    @Override
    public void insert(JobPosition entity) {
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (!currentUserDTO.isEnterprise()) {
            throw new CustomException("只有企业允许添加");
        }
        entity.setEnterpriseId(currentUserDTO.getId());
        check(entity);
        jobPositionMapper.insert(entity);
    }

    @Override
    public void updateById(JobPosition entity) {
        check(entity);
        jobPositionMapper.updateById(entity);
    }

    private void check(JobPosition entity) {

    }

    @Override
    public void removeByIds(List<Integer> ids) {
        jobPositionMapper.removeByIds(ids);
    }
}
