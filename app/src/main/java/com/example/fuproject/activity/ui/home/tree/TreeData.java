package com.example.fuproject.activity.ui.home.tree;

import com.example.fuproject.model.AllEmploymentOfCompany;
import com.example.fuproject.model.Departments;
import com.example.fuproject.model.QueryListResponseList;

//列表项类
public class TreeData {
    private String  name,code,code_id;
    private Boolean hasChild;
    private int Level;
//    private int departmentsID;
    private AllEmploymentOfCompany employmentOfCompany;
    private Departments departments;

    //               名字         当前的ID       上一级的ID       层级      是否可以展开            入职信息                                          部门信息
    public TreeData(String name, String code , String code_id , int Level, Boolean hasChild, AllEmploymentOfCompany employmentOfCompany, Departments departments)
    {
        this.name=name;
        this.code=code;
        this.code_id=code_id;
        this.Level=Level;
        this.hasChild=hasChild;
        this.employmentOfCompany=employmentOfCompany;
        this.departments=departments;
    }

    public AllEmploymentOfCompany getEmploymentOfCompany() {
        return employmentOfCompany;
    }

    public void setEmploymentOfCompany(AllEmploymentOfCompany employmentOfCompany) {
        this.employmentOfCompany = employmentOfCompany;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public int getLevel() {
        return Level;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCode_id() {
        return code_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode_id(String code_id) {
        this.code_id = code_id;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public void setLevel(int level) {
        Level = level;
    }
}
