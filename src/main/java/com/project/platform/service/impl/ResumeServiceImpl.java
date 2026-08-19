package com.project.platform.service.impl;

import com.project.platform.dto.CurrentUserDTO;
import com.project.platform.entity.Resume;
import com.project.platform.exception.CustomException;
import com.project.platform.mapper.ResumeMapper;
import com.project.platform.service.ResumeService;
import com.project.platform.utils.CurrentUserThreadLocal;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 简历
 */
@Service
public class ResumeServiceImpl  implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;
    
    @Override
    public PageVO<Resume> page(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        PageVO<Resume> page = new PageVO();
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (currentUserDTO.isUser()) {
            query.put("userId", currentUserDTO.getId());
        }
        List<Resume> list = resumeMapper.queryPage((pageNum - 1) * pageSize, pageSize, query);
        page.setList(list);
        page.setTotal(resumeMapper.queryCount(query));
        return page;
    }

    @Override
    public Resume selectById(Integer id) {
        Resume resume = resumeMapper.selectById(id);
        return resume;
    }

    @Override
    public List<Resume> list() {
        return resumeMapper.list();
    }
    @Override
    public void insert(Resume entity) {
        CurrentUserDTO currentUserDTO = CurrentUserThreadLocal.getCurrentUser();
        if (!currentUserDTO.getType().equals("USER")) {
            throw new CustomException("只有普通用户允许添加");
        }
        entity.setUserId(currentUserDTO.getId());
        check(entity);
        resumeMapper.insert(entity);
    }
    @Override
    public void updateById(Resume entity) {
        check(entity);
        resumeMapper.updateById(entity);
    }
    private void check(Resume entity) {

    }
    @Override
    public void removeByIds(List<Integer> ids) {
        resumeMapper.removeByIds(ids);
    }
}
