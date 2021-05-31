package com.example.tokoonline.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel (val id:Int, val name:String, val email:String,
                      val password:String)

//{
//    @SerializedName("name")
//    @Expose
//    var name:String? = null
//
//    @SerializedName("email")
//    @Expose
//    var email:String? = null
//
//    @SerializedName("password")
//    @Expose
//    var password:String? = null
//
//    @SerializedName("password_confirmation")
//    @Expose
//    var password_confirmation:String? = null
//}