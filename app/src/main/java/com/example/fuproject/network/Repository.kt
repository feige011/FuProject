package com.example.fuproject.network

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.liveData
import com.example.fuproject.model.*
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchRegister(searchRegister: Register) = liveData(Dispatchers.IO) {
        val result: Result<RegisterResponse> = try {
            val thingsResponse = ThingsNetwork.searchRegister(searchRegister)
            if (thingsResponse.success) {
//                    Log.e("feifei","????????????????????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", thingsResponse.data.toString())
                Log.e("feifei", thingsResponse.code.toString())
                Log.e("feifei", thingsResponse.success.toString())
                Log.e("feifei", thingsResponse.message)
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }


    fun testTelephone(phoneNumber: String) = liveData(Dispatchers.IO) {
        val result: Result<TestTelephoneResponse> = try {
            val thingsResponse = ThingsNetwork.testTelephone(phoneNumber)
            if (thingsResponse.success) {
//                    Log.e("feifei","????????????????????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", thingsResponse.code.toString())
                Log.e("feifei", thingsResponse.success.toString())
                Log.e("feifei", thingsResponse.message)

//                    Log.e("feifei","????????????????????2")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }


    fun enterLogin(login: Login) = liveData(Dispatchers.IO) {
        val result: Result<LoginResponse> = try {
            val thingsResponse = ThingsNetwork.enterLogin(login)
            if (thingsResponse.success) {
//                    Log.e("feifei","????????????????????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
//                    Log.e("feifei","????????????????????2")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    /**
     * 分页查询部门人员基本信息
     */
    fun searchInformationDepartment(InformationDepartmentREST: InformationDepartmentREST) =
        liveData(Dispatchers.IO) {
            val result: Result<InformationDepartmentResponse> = try {
                val thingsResponse =
                    ThingsNetwork.searchInformationDepartment(InformationDepartmentREST)
                if (thingsResponse.success) {
//                    Log.e("feifei","???????????????????????")
                    val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                    Result.success(Things)
                } else {
                    Log.e("feifeiInformathtion", thingsResponse.success.toString())
                    Log.e("feifeiInformathtion", thingsResponse.message)
                    Log.e("feifeiInformathtion", thingsResponse.code.toString())
                    Log.e("feifeiInformathtion", thingsResponse.data.toString())

//                    Log.e("feifei","????????????????????2")
                    Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
                }
            } catch (e: Exception) {
                Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
                Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
            }
            emit(result)
        }

    /**
     * 获取所有公司所有部门的信息
     */
    fun searchAllDepartments() = liveData(Dispatchers.IO) {
        val result: Result<AllDepartmentsResponse> = try {
            val thingsResponse = ThingsNetwork.searchAllDepartments()
            if (thingsResponse.success) {
//                    Log.e("feifei","???????????????????????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifeiInformathtion", thingsResponse.success.toString())
                Log.e("feifeiInformathtion", thingsResponse.message)
                Log.e("feifeiInformathtion", thingsResponse.code.toString())
                Log.e("feifeiInformathtion", thingsResponse.data.toString())

//                    Log.e("feifei","????????????????????2")
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }


    fun searchEmployment(user_id: Int) = liveData(Dispatchers.IO) {
        val result: Result<SearchEmployment> = try {
            val thingsResponse = ThingsNetwork.searchEmployment(user_id)
            if (thingsResponse.success) {
//                    Log.e("feifei","????????????????????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", "WHAT")
                Log.e("feifei", thingsResponse.code.toString())
                Log.e("feifei", thingsResponse.data.toString())
                Log.e("feifei", thingsResponse.message)

                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    fun pageUserSInfo(pageUserSInfo: PageUserSInfo) = liveData(Dispatchers.IO) {
//        Log.e("feifeicao!","查找了")
        val result: Result<PageUserSInfoResponse> = try {
            val thingsResponse = ThingsNetwork.pageUserSInfo(pageUserSInfo)
            if (thingsResponse.code != null) {
//                    Log.e("feifeicao","????????????????????qqqqq????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", "WHAT")
                Log.e("feifei", thingsResponse.code.toString())
                Log.e("feifei", thingsResponse.data.toString())
                Log.e("feifei", thingsResponse.message)
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    fun getAllUserOfCompany(page: Page) = liveData(Dispatchers.IO) {
//        Log.e("feifeicao!","查找了")
        val result: Result<PageUserSInfoResponse> = try {
            val thingsResponse = ThingsNetwork.getAllUserOfCompany(page)
            if (thingsResponse.code != null) {
//                    Log.e("feifeicao","????????????????????qqqqq????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", "WHAT")
                Log.e("feifei", thingsResponse.code.toString())
                Log.e("feifei", thingsResponse.data.toString())
                Log.e("feifei", thingsResponse.message)
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }

    fun getAllEmploymentOfCompany(page: Page) = liveData(Dispatchers.IO) {
//        Log.e("feifeicao!","查找了")
        val result: Result<AllEmploymentOfCompanyResponse> = try {
            val thingsResponse = ThingsNetwork.getAllEmploymentOfCompany(page)
            if (thingsResponse.code != null) {
//                    Log.e("feifeicao","????????????????????qqqqq????")
                val Things = thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            } else {
                Log.e("feifei", "WHAT")
                Log.e("feifei", thingsResponse.code.toString())
                Log.e("feifei", thingsResponse.data.toString())
                Log.e("feifei", thingsResponse.message)
                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message.toString())
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }


//    fun searchThings(searchRegister: SearchRegister) = liveData(Dispatchers.IO) {
//        val result: Result<ThingsRegister> = try {
//            val thingsResponse = ThingsNetwork.searchRegister(searchRegister)
//            if (thingsResponse.code == 200) {
////                    Log.e("feifei","????????????????????")
//                val Things = thingsResponse
////                    Log.e("feifei","${Things.code}")
//                Result.success(Things)
//            } else {
////                    Log.e("feifei","????????????????????2")
//                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
//            }
//        } catch (e: Exception) {
//            Log.e("feifeicuole", e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
//
//
//    fun searchLogin(searchLogin: SearchLogin) = liveData(Dispatchers.IO) {
//        val result: Result<ThingsResponse> = try {
//            val thingsResponse = ThingsNetwork.searchLogin(searchLogin)
//            if (thingsResponse.code != 0) {
//                Log.e("feifei", "????????????????????222")
//                val Things = thingsResponse
//                Log.e("feifei", "${Things.code}")
//                Result.success(Things)
//            } else {
////                Log.e("feifei","????????????????????22")
//                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
//            }
//        } catch (e: Exception) {
//            Log.e("feifeicuole", e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
//
//
//    fun textAccount(account: String) = liveData(Dispatchers.IO) {
//        val result: Result<ThingsRegister> = try {
//            val thingsResponse = ThingsNetwork.testAccount(account)
//            if (thingsResponse.code == 200) {
//                Log.e("feifei", "????????????????????222")
//                val Things = thingsResponse
//                Log.e("feifei", "${Things.code}")
//                Result.success(Things)
//            } else {
//                Log.e("feifei", "????????????????????22")
//                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
//            }
//        } catch (e: Exception) {
//            Log.e("feifeicuole", e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
//
//    //    searchAllProject
//    fun searchAllProject() = liveData(Dispatchers.IO) {
//        val result: Result<SearchProject> = try {
//            val thingsResponse = ThingsNetwork.searchAllProject()
//            if (thingsResponse.code == 200) {
//                Log.e("feifei", "????????????????????222")
//                val Things = thingsResponse
//                Log.e("feifei", "${Things.code}")
//                Result.success(Things)
//            } else {
//                Log.e("feifei", "????????????????????333333")
//                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
//            }
//        } catch (e: Exception) {
//            Log.e("feifeicuole", e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
//
//    fun changePassword(forgetPassword:ForgetPassword) = liveData(Dispatchers.IO) {
//        val result: Result<ThingsRegister> = try {
//            val thingsResponse = ThingsNetwork.changePassword(forgetPassword)
//            if (thingsResponse.code != 0) {
//                Log.e("feifei", "????????????????????222")
//                val Things = thingsResponse
//                Log.e("feifei", "${Things.code}")
//                Result.success(Things)
//            } else {
//                Log.e("feifei",thingsResponse.code.toString())
//                Log.e("feifei", "????????????????????333333")
//                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
//            }
//        } catch (e: Exception) {
//            Log.e("feifeicuole", e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
//
//    fun  releaseProject(releaseProjectMe:ReleaseProjectMe) = liveData(Dispatchers.IO) {
//        val result: Result<ReleaseProject> = try {
//            val thingsResponse = ThingsNetwork.releaseProject(releaseProjectMe)
//            if (thingsResponse.code != 0) {
//                Log.e("feifei", "????????????????????222")
//                val Things = thingsResponse
//                Log.e("feifei", "${Things.code}")
//                Result.success(Things)
//            } else {
//                Log.e("feifei",thingsResponse.code.toString())
//                Log.e("feifei", "????????????????????333333")
//                Result.failure(RuntimeException("response status is ${thingsResponse.code}"))
//            }
//        } catch (e: Exception) {
//            Log.e("feifeicuole", e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
}