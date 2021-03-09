package com.example.fuproject.model
import com.example.fuproject.network.Repository
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ThingsViewModel : ViewModel() {
    val searchLiveData = MutableLiveData<Register>()
//    val placeList = ArrayList<ThingsMe>()
    val placeLiveData = Transformations.switchMap(searchLiveData) {
        Log.e("feifei", "shibai")
        Repository.searchRegister(it)
    }
    fun SearchRegister(
        phoneNumber:String, password:String, confirmPassword:String, verificationCode:String
    ) {
//        Log.e("feifei", "shibai3")
        val m = Register(
             phoneNumber, password,  confirmPassword, verificationCode
        )
        searchLiveData.value = m
//        Log.e("feifei", m.username)
    }

    val searchTelephoneData = MutableLiveData<String>()
    //    val placeList = ArrayList<ThingsMe>()
    val placeTelephoneData = Transformations.switchMap(searchTelephoneData) {
        Log.e("feifei", "shibai")
        Repository.testTelephone(it)
    }
    fun SearchTelephoneData(phoneNumber: String){
        searchTelephoneData.value = phoneNumber
    }

    val enterLoginData = MutableLiveData<Login>()
    //    val placeList = ArrayList<ThingsMe>()
    val placeLoginData = Transformations.switchMap(enterLoginData) {
        Log.e("feifei", "shibai")
        Repository.enterLogin(it)
    }
    fun EnterLoginData(login: Login){
//        Log.e("!!!","```");
        enterLoginData.value = login
    }


    /**
     *分页查询部门人员基本信息
     */
    val searchInformationDepartmentData=  MutableLiveData<InformationDepartmentREST>()

    val placesearchInformationDepartmentData = Transformations.switchMap(searchInformationDepartmentData) {
        Log.e("feifei", "shibai")
        Repository.searchInformationDepartment(it)
    }
    fun SearchInformationDepartmentData(informationDepartmentREST:InformationDepartmentREST){
        searchInformationDepartmentData.value=informationDepartmentREST
    }

    /**
     *
     */

    val searchEmploymentData=MutableLiveData<Int>()

    val getSearchEmploymentData=Transformations.switchMap(searchEmploymentData){
        Repository.searchEmployment(it)
    }
    fun SearchEmployment(use_id:Int){
        searchEmploymentData.value=use_id
    }

    /**
     * 【部门员工入职信息列表】分页查询部门人员基本信息
     */
    val searchPageUserSInfoData=MutableLiveData<PageUserSInfo>()
    val getSearchPageUserSInfoData=Transformations.switchMap(searchPageUserSInfoData){
        Repository.pageUserSInfo(it)
    }
    fun SearchPageUserSInfoData(pageUserSInfo:PageUserSInfo){
        searchPageUserSInfoData.postValue(pageUserSInfo)
    }

    val getAllUserOfCompanyData=MutableLiveData<Page>()
    val getAllUserOfCompanyLiveData=Transformations.switchMap(getAllUserOfCompanyData){
        Repository.getAllUserOfCompany(it)
    }
    fun GetAllUserOfCompanyData(page:Page){
        getAllUserOfCompanyData.value=page
    }


    val getAllEmploymentOfCompanyData=MutableLiveData<Page>()
    val getAllEmploymentOfCompanyLiveData=Transformations.switchMap(getAllEmploymentOfCompanyData){
        Repository.getAllEmploymentOfCompany(it)
    }
    fun GetAllEmploymentOfCompany(page:Page){
        getAllEmploymentOfCompanyData.value=page
    }




//    val searchAllDepartmentsData=MutableLiveData()
//
//    val placeSearchAllDepartmentsData= Transformations.switchMap(searchAllDepartmentsData) {
////        Log.e("feifei", "shibai")
//        Repository.searchAllDepartments(it)
//    }
//    fun SearchAllDepartmentsData(){
//
//    }


//
//    fun searchRegister(
//         phoneNumber:String, password:String,  confirmPassword:String,verificationCode:String
//    ) {
////        Log.e("feifei", "shibai3")
//        val m = Register(
//             phoneNumber, password,  confirmPassword, verificationCode
//        )
//        searchLiveData.value = m
////        Log.e("feifei", m.username)
//    }
//
//    val searchLogin = MutableLiveData<SearchLogin>()
//    val placeLiveDataLogin = Transformations.switchMap(searchLogin) {
//        Log.e("feifei", "shibai")
//        Repository.searchLogin(it)
//    }
//    fun searchLogin(queryAdmin: String, queryPassword: String) {
//        Log.e("feifei", "shibai3")
//        val m = SearchLogin(queryAdmin, queryPassword)
//        searchLogin.value = m
//        Log.e("feifei", m.username)
//    }
//
//
//    val textAccount=MutableLiveData<String>()
//    val LiveDatatextAccount = Transformations.switchMap(textAccount) {
//        Log.e("feifei", "shibai33333333333")
//        Repository.textAccount(it)
//    }
//    fun SearchtextAccount(queryAdmin: String){
//        textAccount.value=queryAdmin
//    }
//
//
//    val searchProject=MutableLiveData<String>()
//    val LivesearchProject = Transformations.switchMap(searchProject) {
//        Log.e("feifei", "shibai33333333333")
//        Repository.searchAllProject()
//    }
//    fun SearchAllProject(queryAdmin: String){
//        searchProject.value=queryAdmin
//    }
//
//    val changePassword=MutableLiveData<ForgetPassword>()
//    val LiveChangePassword=Transformations.switchMap(changePassword){
//        Repository.changePassword(it)
//    }
//    fun ChangePassword(forgetPassword:ForgetPassword){
//        changePassword.value=forgetPassword
//    }
//
//    val  releaseProject= MutableLiveData<ReleaseProjectMe>()
//    val LiveReleaseProject=Transformations.switchMap(releaseProject){
//        Repository.releaseProject(it)
//    }
//    fun ReleaseProject(releaseProjectMe:ReleaseProjectMe){
//        releaseProject.value=releaseProjectMe
//    }




}