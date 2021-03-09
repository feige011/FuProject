package com.example.fuproject.network


import com.example.fuproject.model.*
import retrofit2.Call
import retrofit2.http.*

interface ThingsService {

    //    @FormUrlEncoded@Field("phoneNumber") @Field("password")  @Field("confirmPassword")@Field("verificationCode")
    @POST("user/register")
    fun searchRegister(@Body register: Register): Call<RegisterResponse>

    //    /**
//     * user
//     */
    @GET("Common/getPhoneCheckCode")
    fun testTelephone(@Query("phoneNumber") phoneNumber: String): Call<TestTelephoneResponse>


    @POST("user/login")
    fun enterLogin(
        @Body login: Login
    ): Call<LoginResponse>

    /**
     * 分页查询部门人员基本信息
     */
//    @Multipart
    @GET("department/pageUserSInfo/{current}/{limit}/{departmentId}")
    fun searchInformationDepartment(
        @Header("token") token: String,
        @Path("current") current: String,
        @Path("limit") limit: String,
        @Path("departmentId") departmentId: String
    ): Call<InformationDepartmentResponse>

    @GET("department/getAllDepartments")
    fun searchAllDepartments(@Header("token") token: String): Call<AllDepartmentsResponse>
//    Basic information of department personnel


    // ​
    /**
     * 【部门员工基本信息列表】分页查询部门人员基本信息
     */
    @GET("department/pageUserSInfo/{current}/{limit}/{departmentId}")
    fun pageUserSInfo(
        @Header("token") token: String,
        @Path("current") current: Int,
        @Path("limit") limit: Int,
        @Path("departmentId") departmentId: Int
    ):Call<PageUserSInfoResponse>


//
//    @FormUrlEncoded
//    @POST("user/register")
//    fun searchRegister(
//        @Field("username") name: String,
//        @Field("account") account: String,
//        @Field("password") password: String,
//        @Field("secret_password1") secret_password1: String,
//        @Field("secret_password2") secret_password2: String,
//        @Field("secret_password3") secret_password3: String
//    ): Call<ThingsRegister>
//
//    @FormUrlEncoded
//    @POST("user/login")
//    fun searchLogin(
//        @Field("account") account: String,
//        @Field("password") password: String
//    ): Call<ThingsResponse>
//
//
//
//    @FormUrlEncoded
//    @POST("user/updatePassword")
//    fun changePassword(
//        @Field("account") account: String,
//        @Field("newPassword") password: String,
//        @Field("secret_password1") secret_password1: String,
//        @Field("secret_password2") secret_password2: String,
//        @Field("secret_password3") secret_password3: String
//    ): Call<ThingsRegister>
//
//    /**
//    * project
//    */
//    @GET("project/getAllProjects")
//    fun searchAllProject(): Call<SearchProject>
//
//    @FormUrlEncoded
//    @POST("project/releaseProject")
//    fun releaseProject(
//        @Field("account") account:String,
//        @Field("projectName") projectName:String,
//        @Field("sketchPorject")sketchPorject:String,
//        @Field("mainProject")mainProject:String
//    ):Call<ReleaseProject>

    @GET("department/queryListByAdministratorId")
    fun searchQueryList(@Header("token") token: String): Call<SearchQueryListResponse>

    //根据员工的id创建评价记录
    @GET("employment/last/{userId}")
    fun searchEmployment(
        @Header("token") token: String,
        @Path("userId") user_id: Int
    ): Call<SearchEmployment>

    /**
     *     【公司员工基本信息列表】获取当前用户所在公司的所有员工基本信息
     */
    @GET("company/getAllUserOfCompany/{pageNo}/{pageSize}")
    fun getAllUserOfCompany(@Header("token") token: String,@Path("pageNo") pageNo:Int,@Path("pageSize") pageSize:Int):Call<PageUserSInfoResponse>

    /**
     * 【公司员工基本信息列表】获取当前用户所在公司的所有员工入职信息
     */
    @GET("company/getAllEmploymentOfCompany/{pageNo}/{pageSize}")
    fun getAllEmploymentOfCompany(@Header("token") token:String, @Path("pageNo") pageNo:Int, @Path("pageSize") pageSize:Int):Call<AllEmploymentOfCompanyResponse>
}