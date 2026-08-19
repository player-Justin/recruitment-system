package com.project.platform.entity;

import java.time.LocalDateTime;
/**
 * 企业
 */
public class Enterprise  {
   /**
    * id
    */
   private Integer id;
   /**
    * 用户名
    */
   private String username;
   /**
    * 密码
    */
   private String password;
   /**
    * 昵称
    */
   private String nickname;
   /**
    * 头像
    */
   private String avatarUrl;
   /**
    * 电话
    */
   private String tel;
   /**
    * 邮箱
    */
   private String email;
   /**
    * 状态
    */
   private String status;
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
   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public String getAvatarUrl() {
      return avatarUrl;
   }

   public void setAvatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getIndustry() {
      return industry;
   }

   public void setIndustry(String industry) {
      this.industry = industry;
   }

   public String getScale() {
      return scale;
   }

   public void setScale(String scale) {
      this.scale = scale;
   }

   public String getNature() {
      return nature;
   }

   public void setNature(String nature) {
      this.nature = nature;
   }

   public String getFoundingYear() {
      return foundingYear;
   }

   public void setFoundingYear(String foundingYear) {
      this.foundingYear = foundingYear;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getIntro() {
      return intro;
   }

   public void setIntro(String intro) {
      this.intro = intro;
   }

   public String getAuditStatus() {
      return auditStatus;
   }

   public void setAuditStatus(String auditStatus) {
      this.auditStatus = auditStatus;
   }

   public String getReviewComment() {
      return reviewComment;
   }

   public void setReviewComment(String reviewComment) {
      this.reviewComment = reviewComment;
   }

   public LocalDateTime getCreateTime() {
      return createTime;
   }

   public void setCreateTime(LocalDateTime createTime) {
      this.createTime = createTime;
   }


}
