package com.project.platform.service.impl;

import com.project.platform.dto.CurrentUserDTO;
import com.project.platform.entity.InterviewRecord;
import com.project.platform.mapper.InterviewRecordMapper;
import com.project.platform.service.InterviewRecordService;
import com.project.platform.utils.CurrentUserThreadLocal;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 面试记录
 */
@Service
public class InterviewRecordServiceImpl  implements InterviewRecordService {
    @Resource
    private InterviewRecordMapper interviewRecordMapper;
    
    @Override
    public PageVO<InterviewRecord> page(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        PageVO<InterviewRecord> page = new PageVO();
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (currentUserDTO.isEnterprise()) {
            query.put("enterpriseId", currentUserDTO.getId());
        }
        if (currentUserDTO.isUser()) {
            query.put("userId", currentUserDTO.getId());
        }
        List<InterviewRecord> list = interviewRecordMapper.queryPage((pageNum - 1) * pageSize, pageSize, query);
        page.setList(list);
        page.setTotal(interviewRecordMapper.queryCount(query));
        return page;
    }

    @Override
    public InterviewRecord selectById(Integer id) {
        InterviewRecord interviewRecord = interviewRecordMapper.selectById(id);
        return interviewRecord;
    }

    @Override
    public List<InterviewRecord> list() {
        return interviewRecordMapper.list();
    }
    @Override
    public void insert(InterviewRecord entity) {
        check(entity);
        entity.setStatus("待确认");
        interviewRecordMapper.insert(entity);
    }
    @Override
    public void updateById(InterviewRecord entity) {
        check(entity);
        interviewRecordMapper.updateById(entity);
    }
    private void check(InterviewRecord entity) {

    }
    @Override
    public void removeByIds(List<Integer> ids) {
        interviewRecordMapper.removeByIds(ids);
    }
}
