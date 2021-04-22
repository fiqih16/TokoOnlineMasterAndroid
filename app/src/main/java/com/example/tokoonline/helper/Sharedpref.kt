package com.example.tokoonline.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.tokoonline.activity.LoginActivity

class SharedPref(activity: Activity) {

    val login = "Login"

    val mypref = "FFFFFFF"
    val sp:SharedPreferences

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin():Boolean{
        return sp.getBoolean(login,false)
    }

}