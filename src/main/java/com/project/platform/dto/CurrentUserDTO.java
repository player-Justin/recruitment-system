package com.project.platform.dto;

import lombok.Data;

@Data
public class CurrentUserDTO {
    private Integer id;
    private String type;
    private String username;
    private String nickname;
    private String avatarUrl;
    private String tel;
    private String email;

    /**
     * 企业名称
     */
    private String name;
    /**
     * 社会信用代码
     */
    private String code;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 规模
     */
    private String scale;
    /**
     * 性质
     */
    private String nature;
    /**
     * 成立年份
     */
    private String foundingYear;
    /**
     * 地址
     */
    private String address;
    /**
     * 简介
     */
    private String intro;
    /**
     * 审核状态
     */
    private String auditStatus;
    /**
     * 审核意见
     */
    private String reviewComment;


    public boolean isAdmin() {
        return "ADMIN".equals(type);
    }
    public boolean isEnterprise() {
        return "ENTERPRISE".equals(type);
    }
    public boolean isUser() {
        return "USER".equals(type);
    }

}
