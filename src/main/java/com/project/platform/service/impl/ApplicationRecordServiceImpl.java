package com.project.platform.service.impl;

import com.project.platform.dto.CurrentUserDTO;
import com.project.platform.entity.ApplicationRecord;
import com.project.platform.entity.JobPosition;
import com.project.platform.exception.CustomException;
import com.project.platform.mapper.ApplicationRecordMapper;
import com.project.platform.mapper.JobPositionMapper;
import com.project.platform.service.ApplicationRecordService;
import com.project.platform.utils.CurrentUserThreadLocal;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 投递记录
 */
@Service
public class ApplicationRecordServiceImpl implements ApplicationRecordService {
    @Resource
    private ApplicationRecordMapper applicationRecordMapper;
    @Resource
    private JobPositionMapper jobPositionMapper;

    @Override
    public PageVO<ApplicationRecord> page(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        PageVO<ApplicationRecord> page = new PageVO();
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (currentUserDTO.isEnterprise()) {
            query.put("enterpriseId", currentUserDTO.getId());
        }
        if (currentUserDTO.isUser()) {
            query.put("userId", currentUserDTO.getId());
        }
        List<ApplicationRecord> list = applicationRecordMapper.queryPage((pageNum - 1) * pageSize, pageSize, query);
        page.setList(list);
        page.setTotal(applicationRecordMapper.queryCount(query));
        return page;
    }

    @Override
    public ApplicationRecord selectById(Integer id) {
        ApplicationRecord applicationRecord = applicationRecordMapper.selectById(id);
        return applicationRecord;
    }

    @Override
    public List<ApplicationRecord> list() {
        return applicationRecordMapper.list();
    }

    @Override
    public void insert(ApplicationRecord entity) {
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (!currentUserDTO.getType().equals("USER")) {
            throw new CustomException("只有普通用户允许申请");
        }
        entity.setUserId(currentUserDTO.getId());
        JobPosition jobPosition = jobPositionMapper.selectById(entity.getJobPositionId());
        entity.setEnterpriseId(jobPosition.getEnterpriseId());
        entity.setStatus("待处理");
        check(entity);
        jobPosition.setQuantityOfDelivery(jobPosition.getQuantityOfDelivery() + 1);
        jobPositionMapper.updateById(jobPosition);
        applicationRecordMapper.insert(entity);
    }

    @Override
    public void updateById(ApplicationRecord entity) {
        check(entity);
        applicationRecordMapper.updateById(entity);
    }

    private void check(ApplicationRecord entity) {

    }

    @Override
    public void removeByIds(List<Integer> ids) {
        applicationRecordMapper.removeByIds(ids);
    }
}
