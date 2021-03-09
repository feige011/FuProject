package com.example.fuproject.activity.ui.home.tree;

import java.util.Date;

public class DepartmentPeopleBean {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
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

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getPositiveDate() {
        return positiveDate;
    }

    public void setPositiveDate(Date positiveDate) {
        this.positiveDate = positiveDate;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getHireForm() {
        return hireForm;
    }

    public void setHireForm(int hireForm) {
        this.hireForm = hireForm;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRolePermMessage() {
        return RolePermMessage;
    }

    public void setRolePermMessage(String rolePermMessage) {
        RolePermMessage = rolePermMessage;
    }

    public DepartmentPeopleBean(String name, int gender, String idNumber, String political, String stature, String phoneNumber, String email, String registerAddress, String birthDate, String nation, String martialStatus, String graduateSchool, String degree, String profession, String selfAssessment, String jobNumber, Date hireDate, Date positiveDate, Date contractStartDate, Date contractEndDate, int hireForm, String jobName, int departmentId, String description, String rolePermMessage) {

        this.name = name;
        this.gender = gender;
        this.idNumber = idNumber;
        this.political = political;
        this.stature = stature;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.registerAddress = registerAddress;
        this.birthDate = birthDate;
        this.nation = nation;
        this.martialStatus = martialStatus;
        this.graduateSchool = graduateSchool;
        this.degree = degree;
        this.profession = profession;
        this.selfAssessment = selfAssessment;
        this.jobNumber = jobNumber;
        this.hireDate = hireDate;
        this.positiveDate = positiveDate;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.hireForm = hireForm;
        this.jobName = jobName;
        this.departmentId = departmentId;
        this.description = description;
        RolePermMessage = rolePermMessage;
    }

    int gender;
    String idNumber;
    String political;
    String stature;
    String phoneNumber;
    String email;
    String registerAddress;
    String birthDate;
    String nation;
    String martialStatus;
    String graduateSchool;
    String degree;
    String profession;
    String selfAssessment;
    String jobNumber;
    Date hireDate;
    Date positiveDate;
    Date contractStartDate;
    Date contractEndDate;
    int hireForm;
    String jobName;
    int departmentId;
    String description;
    String RolePermMessage;
}
