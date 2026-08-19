package com.project.platform.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.project.platform.dto.CurrentUserDTO;
import com.project.platform.dto.RetrievePasswordDTO;
import com.project.platform.dto.UpdatePasswordDTO;
import com.project.platform.entity.Enterprise;
import com.project.platform.exception.CustomException;
import com.project.platform.mapper.EnterpriseMapper;
import com.project.platform.service.EnterpriseService;
import com.project.platform.utils.CurrentUserThreadLocal;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.project.platform.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * 企业
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Value("${resetPassword}")
    private String resetPassword;

    @Override
    public PageVO<Enterprise> page(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        PageVO<Enterprise> page = new PageVO();
        List<Enterprise> list = enterpriseMapper.queryPage((pageNum - 1) * pageSize, pageSize, query);
        page.setList(list);
        page.setTotal(enterpriseMapper.queryCount(query));
        return page;
    }

    @Override
    public Enterprise selectById(Integer id) {
        Enterprise enterprise = enterpriseMapper.selectById(id);
        return enterprise;
    }

    @Override
    public List<Enterprise> list() {
        return enterpriseMapper.list();
    }

    @Override
    public void insert(Enterprise entity) {
        check(entity);
        if (entity.getPassword() == null) {
            entity.setPassword(resetPassword);
        }
        if (entity.getAuditStatus() == null) {
            entity.setAuditStatus("待审核");
        }
        if (entity.getStatus() == null) {
            entity.setStatus("启用");
        }
        enterpriseMapper.insert(entity);
    }

    @Override
    public void updateById(Enterprise entity) {
        check(entity);
        enterpriseMapper.updateById(entity);
    }

    private void check(Enterprise entity) {
        Enterprise enterprise = enterpriseMapper.selectByUsername(entity.getUsername());
        if (enterprise != null && enterprise.getId() != entity.getId()) {
            throw new CustomException("用户名已存在");
        }
    }

    @Override
    public void removeByIds(List<Integer> ids) {
        enterpriseMapper.removeByIds(ids);
    }


    @Override
    public CurrentUserDTO login(String enterprisename, String password) {
        Enterprise enterprise = enterpriseMapper.selectByUsername(enterprisename);
        if (enterprise == null || !enterprise.getPassword().equals(password)) {
            throw new CustomException("用户名或密码错误");
        }
        if (enterprise.getStatus().equals("禁用")) {
            throw new CustomException("用户已禁用");
        }
        CurrentUserDTO currentUserDTO = new CurrentUserDTO();
        BeanUtils.copyProperties(enterprise, currentUserDTO);
        return currentUserDTO;
    }

    @Override
    public void register(JSONObject data) {
        Enterprise enterprise = new Enterprise();
        enterprise.setUsername(data.getString("username"));
        enterprise.setNickname(data.getString("nickname"));
        enterprise.setAvatarUrl(data.getString("avatarUrl"));
        enterprise.setPassword(data.getString("password"));
        enterprise.setStatus("启用");
        enterprise.setAuditStatus("待审核");
        insert(enterprise);
    }


    @Override
    public void updateCurrentUserInfo(CurrentUserDTO currentUserDTO) {
        Enterprise enterprise = enterpriseMapper.selectById(currentUserDTO.getId());
        BeanUtils.copyProperties(currentUserDTO, enterprise);
        enterpriseMapper.updateById(enterprise);
    }

    @Override
    public void updateCurrentUserPassword(UpdatePasswordDTO updatePassword) {
        Enterprise enterprise = enterpriseMapper.selectById(CurrentUserThreadLocal.getCurrentUser().getId());
        if (!enterprise.getPassword().equals(updatePassword.getOldPassword())) {
            throw new CustomException("旧密码不正确");
        }
        enterprise.setPassword(updatePassword.getNewPassword());
        enterpriseMapper.updateById(enterprise);
    }

    @Override
    public void resetPassword(Integer id) {
        Enterprise enterprise = enterpriseMapper.selectById(id);
        enterprise.setPassword(resetPassword);
        enterpriseMapper.updateById(enterprise);
    }

    @Override
    public void retrievePassword(RetrievePasswordDTO retrievePasswordDTO) {
        Enterprise enterprise = enterpriseMapper.selectByTel(retrievePasswordDTO.getTel());
        if (enterprise == null) {
            throw new CustomException("手机号不存在");
        }
        //TODO 校验验证码
        enterprise.setPassword(retrievePasswordDTO.getPassword());
        enterpriseMapper.updateById(enterprise);
    }

}