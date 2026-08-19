package com.project.platform.entity;

import java.time.LocalDateTime;
/**
 * 面试记录
 */
public class InterviewRecord  {
   /**
    * id
    */
   private Integer id;
   /**
   * 用户
   */
   private Integer userId;
   /**
   * 用户
   */
   private String userName;
   /**
   * 简历
   */
   private Integer resumeId;
   /**
   * 简历
   */
   private String resumeName;
   /**
   * 职位
   */
   private Integer jobPositionId;
   /**
   * 职位
   */
   private String jobPosition;
   /**
   * 企业
   */
   private Integer enterpriseId;
   /**
   * 企业
   */
   private String enterpriseName;
   /**
   * 预约时间
   */
   private LocalDateTime subscribeTime;
   /**
   * 备注
   */
   private String remark;
   /**
   * 状态
   */
   private String status;
   /**
   * 企业反馈信息
   */
   private String feedback;
   /**
   * 创建时间
   */
   private LocalDateTime createTime;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
   public Integer getUserId() {
      return userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public Integer getResumeId() {
      return resumeId;
   }

   public void setResumeId(Integer resumeId) {
      this.resumeId = resumeId;
   }

   public String getResumeName() {
      return resumeName;
   }

   public void setResumeName(String resumeName) {
      this.resumeName = resumeName;
   }

   public Integer getJobPositionId() {
      return jobPositionId;
   }

   public void setJobPositionId(Integer jobPositionId) {
      this.jobPositionId = jobPositionId;
   }

   public String getJobPosition() {
      return jobPosition;
   }

   public void setJobPosition(String jobPosition) {
      this.jobPosition = jobPosition;
   }

   public Integer getEnterpriseId() {
      return enterpriseId;
   }

   public void setEnterpriseId(Integer enterpriseId) {
      this.enterpriseId = enterpriseId;
   }

   public String getEnterpriseName() {
      return enterpriseName;
   }

   public void setEnterpriseName(String enterpriseName) {
      this.enterpriseName = enterpriseName;
   }

   public LocalDateTime getSubscribeTime() {
      return subscribeTime;
   }

   public void setSubscribeTime(LocalDateTime subscribeTime) {
      this.subscribeTime = subscribeTime;
   }

   public String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getFeedback() {
      return feedback;
   }

   public void setFeedback(String feedback) {
      this.feedback = feedback;
   }

   public LocalDateTime getCreateTime() {
      return createTime;
   }

   public void setCreateTime(LocalDateTime createTime) {
      this.createTime = createTime;
   }


}
