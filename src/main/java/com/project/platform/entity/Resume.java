package com.project.platform.entity;

import java.time.LocalDateTime;
/**
 * 简历
 */
public class Resume  {
   /**
    * id
    */
   private Integer id;
   /**
   * 名称
   */
   private String name;
   /**
   * 姓名
   */
   private String fullName;
   /**
   * 性别
   */
   private String gender;
   /**
   * 出生日期
   */
   private String birthDate;
   /**
   * 联系电话
   */
   private String phoneNumber;
   /**
   * 联系邮箱
   */
   private String email;
   /**
   * 期望职位
   */
   private String expectedPosition;
   /**
   * 期望薪资
   */
   private String expectedSalary;
   /**
   * 简历文件的URL
   */
   private String resumeUrl;
   /**
   * 教育经历
   */
   private String educationExperience;
   /**
   * 工作经历
   */
   private String workExperience;
   /**
   * 项目经验
   */
   private String projectExperience;
   /**
   * 技能
   */
   private String skills;
   /**
   * 用户ID
   */
   private Integer userId;
   /**
   * 用户名称
   */
   private String userName;
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
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getExpectedPosition() {
      return expectedPosition;
   }

   public void setExpectedPosition(String expectedPosition) {
      this.expectedPosition = expectedPosition;
   }

   public String getExpectedSalary() {
      return expectedSalary;
   }

   public void setExpectedSalary(String expectedSalary) {
      this.expectedSalary = expectedSalary;
   }

   public String getResumeUrl() {
      return resumeUrl;
   }

   public void setResumeUrl(String resumeUrl) {
      this.resumeUrl = resumeUrl;
   }

   public String getEducationExperience() {
      return educationExperience;
   }

   public void setEducationExperience(String educationExperience) {
      this.educationExperience = educationExperience;
   }

   public String getWorkExperience() {
      return workExperience;
   }

   public void setWorkExperience(String workExperience) {
      this.workExperience = workExperience;
   }

   public String getProjectExperience() {
      return projectExperience;
   }

   public void setProjectExperience(String projectExperience) {
      this.projectExperience = projectExperience;
   }

   public String getSkills() {
      return skills;
   }

   public void setSkills(String skills) {
      this.skills = skills;
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

   public LocalDateTime getCreateTime() {
      return createTime;
   }

   public void setCreateTime(LocalDateTime createTime) {
      this.createTime = createTime;
   }


}
