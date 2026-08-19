package com.project.platform.entity;

import java.time.LocalDateTime;
/**
 * 职位
 */
public class JobPosition  {
   /**
    * id
    */
   private Integer id;
   /**
    * 名称
    */
   private String name;
   /**
    * 类型
    */
   private String type;
   /**
    * 薪资范围
    */
   private String salaryRange;
   /**
    * 工作城市
    */
   private String city;
   /**
    * 具体工作地址
    */
   private String workAddress;
   /**
    * 经验要求
    */
   private String experienceRequired;
   /**
    * 学历要求
    */
   private String educationRequired;
   /**
    * 职责要求
    */
   private String responsibilities;
   /**
    * 投递量
    */
   private Integer quantityOfDelivery;
   /**
    * 所属企业
    */
   private Integer enterpriseId;
   /**
    * 所属企业
    */
   private String enterpriseName;
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

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getSalaryRange() {
      return salaryRange;
   }

   public void setSalaryRange(String salaryRange) {
      this.salaryRange = salaryRange;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getWorkAddress() {
      return workAddress;
   }

   public void setWorkAddress(String workAddress) {
      this.workAddress = workAddress;
   }

   public String getExperienceRequired() {
      return experienceRequired;
   }

   public void setExperienceRequired(String experienceRequired) {
      this.experienceRequired = experienceRequired;
   }

   public String getEducationRequired() {
      return educationRequired;
   }

   public void setEducationRequired(String educationRequired) {
      this.educationRequired = educationRequired;
   }

   public String getResponsibilities() {
      return responsibilities;
   }

   public void setResponsibilities(String responsibilities) {
      this.responsibilities = responsibilities;
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

   public LocalDateTime getCreateTime() {
      return createTime;
   }

   public void setCreateTime(LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public Integer getQuantityOfDelivery() {
      return quantityOfDelivery;
   }

   public void setQuantityOfDelivery(Integer quantityOfDelivery) {
      this.quantityOfDelivery = quantityOfDelivery;
   }
}
