import com.example.fuproject.model.*
import com.example.fuproject.network.ServiceCreator
import com.example.fuproject.network.ThingsService
import com.example.fuproject.network.TokenStatic
import com.example.fuproject.network.TokenStatic.Companion.TOKEN
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Path
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object ThingsNetwork {
    private val placeService = ServiceCreator.create(ThingsService::class.java)

    //    suspend fun searchRegister( searchRegister: SearchRegister)= placeService.searchRegister(searchRegister.username,searchRegister.account,searchRegister.password,searchRegister.secret_password1,searchRegister.secret_password2,searchRegister.secret_password3).await()
//
//    suspend fun testAccount(account:String)=placeService.testAccount(account).await()
//
//    suspend fun searchLogin( searchAdmin: SearchLogin)= placeService.searchLogin(searchAdmin.username,searchAdmin.password).await()
//
//    suspend fun searchAllProject()= placeService.searchAllProject().await()
//
//    suspend fun releaseProject(releaseProjectMe: ReleaseProjectMe)= placeService.releaseProject(releaseProjectMe.account,releaseProjectMe.project.projectName,releaseProjectMe.project.sketchProject,releaseProjectMe.project.mainProject).await()
//
//    suspend fun changePassword(forgetPassword: ForgetPassword)= placeService.changePassword(forgetPassword.account,forgetPassword.password,forgetPassword.secret_password1,forgetPassword.secret_password2,forgetPassword.secret_password3).await()
    suspend fun searchRegister(register: Register) = placeService.searchRegister(
        register
    ).await()


    suspend fun testTelephone(phoneNumber: String) = placeService.testTelephone(phoneNumber).await()

    suspend fun enterLogin(login: Login) = placeService.enterLogin(
        login
    ).await()

    suspend fun searchInformationDepartment(informationDepartmentREST: InformationDepartmentREST) =
        placeService.searchInformationDepartment(
            TokenStatic.TOKEN,
            informationDepartmentREST.current,
            informationDepartmentREST.limit,
            informationDepartmentREST.departmentId
        ).await()

    suspend fun searchAllDepartments()= placeService.searchAllDepartments(TokenStatic.TOKEN).await()

    suspend fun searchEmployment(user_id:Int)= placeService.searchEmployment(TOKEN,user_id).await()

    suspend fun pageUserSInfo(pageUserSInfo: PageUserSInfo)= placeService.pageUserSInfo(TOKEN,pageUserSInfo.current,pageUserSInfo.limit, pageUserSInfo.departmentId).await()

    suspend fun getAllUserOfCompany(page: Page)=
        placeService.getAllUserOfCompany(TOKEN,page.pageNo,page.pageSize).await()

    suspend fun getAllEmploymentOfCompany(page: Page)=
        placeService.getAllEmploymentOfCompany(TOKEN,page.pageNo,page.pageSize).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine {
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) it.resume(body)
                    else it.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }
            })
        }
    }


}