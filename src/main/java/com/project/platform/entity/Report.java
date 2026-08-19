package com.project.platform.entity;

import lombok.Data;

@Data
public class Report {
    private Integer id;
    private Integer reporterId;
    private Integer enterpriseId;
    private String replyFormAdmin;
    private String reason;
}