package com.example.fuproject.model

import retrofit2.http.Path
import java.util.*

data class LoginResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: Map<String, String>
)

data class Login(
    val phoneNumber: String,
    val password: String,
    val verificationCode: String,
    val rememberMe: Boolean,
    val type: Int
)

data class RegisterResponse(val success: Boolean, val code: Int, val message: String, val data: Any)
data class Register(
    val phoneNumber: String,
    val password: String,
    val confirmPassword: String,
    val verificationCode: String
)

data class TestTelephoneResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: Any
)

/**
 * 分页查询部门人员基本信息
 */
data class InformationDepartmentREST(
    val current: String,
    val limit: String,
    val departmentId: String
)

data class InformationDepartmentResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: InformationDepartmentResponseData
)

data class InformationDepartmentResponseData(
    val total: String,
    val list: List<InformationDepartmentResponseDataList>
)

data class InformationDepartmentResponseDataList(
    val id: Int,
    val name: String,
    val avatar: String,
    val isEmployed: Int,
    val gender: Int,
    val idNumber: String,
    val political: String,
    val stature: Float,
    val phoneNumber: String,
    val password: String,
    val email: String,
    val registerAddress: String,
    val residenceAddress: String,
    val birthDate: String,
    val nation: String,
    val martialStatus: Int,
    val graduateSchool: String,
    val degree: String,
    val selfAssessment: String,
    val profession: String,
    val credit: Int,
    val createTime: String,
    val updateTime: String,
    val isDelete: Int,
    val version: Int
)

/**
 * 获取所有公司所有部门的信息
 */
data class AllDepartmentsResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: DepartmentsResponse
)

data class DepartmentsResponse(val total: Int, val list: List<Departments>)
data class Departments(
    val id: Int,
    val companyId: Int,
    val name: String,
    val parentId: Int,
    val administratorId: Int,
    val isDelete: Int,
    val children: List<Departments>
)

//查询部门主管所管理的部门，【查看我管理的部门】
data class SearchQueryListResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: QueryListResponseData
)

data class QueryListResponseData(val list: List<QueryListResponseList>)
data class QueryListResponseList(
    val id: Int,
    val companyId: Int,
    val administratorId: Int,
    val name: String,
    val parentId: String,
    val children: List<QueryListResponseList>
)

//【查看该职员当前的入职记录】
data class SearchEmployment(val code: Int, val data: Any, val message: String, val success: Boolean)

//【部门员工入职信息列表】分页查询部门人员基本信息
data class PageUserSInfoResponse(
    val code: Int,
    val data: PageUserSInfoResponseData,
    val message: String,
    val success: Boolean
)

data class PageUserSInfoResponseData(val total: Int, val list: List<PageUserSInfoResponseList>)
data class PageUserSInfoResponseList(
    val id: Int,
    val name: String,
    val avatar: String,
    val isEmployed: Double,
    val gender: Double,
    val isNumber: String,
    val political: String,
    val stature: Double,
    val phoneNumber: String,
    val password: String,
    val encryptSalt: String,
    val email: String,
    val registerAddress: String,
    val residenceAddress: String,
    val birthDate: String,
    val nation: String,
    val martialStatus: Double,
    val graduateSchool: String,
    val degree: String,
    val selfAssessment: String,
    val profession: String,
    val credit: Double,
    val createTime: String,
    val updateTime: String,
    val isDelete: Double,
    val version: String
)

data class PageUserSInfo(val current: Int, val limit: Int, val departmentId: Int)

data class Page(val pageNo:Int,val pageSize :Int)

data class AllTreeDate(val allEmploymentOfCompanyList:List<AllEmploymentOfCompany>,val departments:Departments,val children: ArrayList<AllTreeDate>)
//【分页查询入职信息】获取当前用户所在公司的所有员工入职信息
data class AllEmploymentOfCompanyResponse(val code: Int,val data: AllEmploymentOfCompanyData,val message: String,val success: Boolean)
data class AllEmploymentOfCompanyData(val total: Int,val list: List<AllEmploymentOfCompany>)
data class AllEmploymentOfCompany(val employmentId:Int,val userId:Int,val  name:String,val avata:String,val companyId:Int,val companyName:String,val departmentName:String,val  jobName:String,val hireDate:String,val  positiveDate:String,val  contractStartDate:String,val  contractEndDate:String,val hireForm:String)


//名字+职位
data class BaseThings(val name:String ,val employee:String)

//内容+视频地址
data class RadioThings(val things: String,val url:String)

//@Path("current") current: Int,
//@Path("limit") limit: Int,
//@Path("departmentId") departmentId: Int

//{total=2.0, list=[
//    {
//        id =
//            21.0, name = 新员工姓名, avatar = null, isEmployed = 1.0, gender = 1.0, idNumber = 430***********1234, political = 党员, stature = 178.0, phoneNumber = 189****1234, password = d54f78d5deaf0ab5574cdedbd5fe79e9, encryptSalt = 1e629, email = email.com, registerAddress = 户籍所在地, residenceAddress = 住址, birthDate = 2021-02-26T09:17:30.000+00:00, nation = 汉族, martialStatus = 0.0, graduateSchool = 毕业学校, degree = 学位, selfAssessment = 自我描述, profession = 专业, credit = 100.0, createTime = 2021-02-26T09:17:30.000+00:00, updateTime = 2021-02-26T09:17:30.000+00:00, isDelete = 0.0, version = null
//    },
//    {
//        id =
//            18.0, name = 新员工姓名, avatar = 头像url, isEmployed = 1.0, gender = 1.0, idNumber = 430***********1234, political = 党员, stature = 178.0, phoneNumber = 189****1234, password = 30ff93354793c6d8803bb70da329f17a, encryptSalt = ee60c, email = email.com, registerAddress = 户籍所在地, residenceAddress = 住址, birthDate = 2021-02-25T16:07:58.000+00:00, nation = 汉族, martialStatus = 0.0, graduateSchool = 毕业学校, degree = 学位, selfAssessment = 自我描述, profession = 专业, credit = 100.0, createTime = 2021-02-25T16:07:58.000+00:00, updateTime = 2021-02-25T16:07:58.000+00:00, isDelete = 0.0, version = null
//    }]
//}
