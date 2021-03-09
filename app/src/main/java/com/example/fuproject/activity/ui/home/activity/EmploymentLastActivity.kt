package com.example.fuproject.activity.ui.home.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fuproject.R
import com.example.fuproject.activity.CompanyActivity
import com.example.fuproject.activity.ui.home.HomeFragment
import com.example.fuproject.activity.ui.home.tree.TreeData
import com.example.fuproject.activity.ui.home.tree.TreeListAdapter
import com.example.fuproject.activity.ui.home.tree.TreeListPeopleAdapter
import com.example.fuproject.model.*
import com.example.fuproject.network.ServiceCreator
import com.example.fuproject.network.ThingsService
import com.example.fuproject.network.TokenStatic
import kotlinx.android.synthetic.main.activity_employment_last.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmploymentLastActivity : AppCompatActivity() {
    lateinit var allEmploymentOfCompanyList: List<AllEmploymentOfCompany>
    var treeData: ArrayList<TreeData> = ArrayList()
    lateinit var context:Context
    var codeMe =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employment_last)

        context=this
        val allTreeDate= HomeFragment.homeAllTreeData
        allEmploymentOfCompanyList=HomeFragment.staticAllEmploymentOfCompanyList
        if(allTreeDate.isNotEmpty() and   allEmploymentOfCompanyList.isNotEmpty()){
            Log.e("fefeifeihahaha",allTreeDate.size.toString())
            doAddAll2(allTreeDate,0,0,1)
            employment_last_recyclerView?.layoutManager = LinearLayoutManager(context)
            val treeListAdapter = TreeListPeopleAdapter(context, treeData)
            employment_last_recyclerView.adapter = treeListAdapter
        }

    }
    fun doAddAll2(list:ArrayList<AllTreeDate>, code: Int, code_id: Int, level: Int) {
        for (allTreeDate in list) {
            codeMe += 1
            if (allTreeDate.departments.children.isEmpty()) {
                Log.e(
                    "feifeiSee2",
                    "name=${allTreeDate.departments.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                )
                treeData.add(
                    TreeData(
                        allTreeDate.departments.name,
                        codeMe.toString(),
                        code_id.toString(),
                        level,
                        false,
                        null,
                          allTreeDate.departments
                    )
                )
                if(allTreeDate.allEmploymentOfCompanyList.isNotEmpty()){
                    for(allEmploymentOfCompany in allEmploymentOfCompanyList){
                        codeMe++;
                        Log.e(
                            "feifeiSee3f",
                            "name=${ allEmploymentOfCompany.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                        )
                        treeData.add(
                            TreeData(
                                allEmploymentOfCompany.name,
                                HomeFragment.codeMe.toString(),
                                code_id.toString(),
                                level,
                                false,
                                allEmploymentOfCompany,
                                null

                            )
                        )
                    }
                }
            } else {
                Log.e(
                    "feifeiSee2",
                    "name=${allTreeDate.departments.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                )
                treeData.add(
                    TreeData(
                        allTreeDate.departments.name,codeMe.toString(), code_id.toString(),
                        level,
                        true,
                        null,
                        allTreeDate.departments
                    )
                )
                if(allTreeDate.allEmploymentOfCompanyList.isNotEmpty()){
                    for(allEmploymentOfCompany in allEmploymentOfCompanyList){
                        Log.e(
                            "feifeiSee3e",
                            "name=${ allEmploymentOfCompany.name}  codeMe=${codeMe} code_id=${code_id} level=${level}"
                        )
                        codeMe++;
                        treeData.add(
                            TreeData(
                                allEmploymentOfCompany.name,
                                codeMe.toString(),
                                code.toString(),
                                level+1,
                                false,
                                allEmploymentOfCompany,
                                null
                            )
                        )
                    }
                }
                doAddAll2(allTreeDate.children,codeMe, code, level + 1)
            }
        }
//        }

    }


}