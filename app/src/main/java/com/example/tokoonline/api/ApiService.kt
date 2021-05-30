package com.example.tokoonline.api

import com.example.tokoonline.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/register")
    fun regisUser(@Body newUserModel : UserModel) : Call<UserModel>

    @POST("/api/v1/login")
    fun loginUser(@Body newUserModel : UserModel) : Call<UserModel>
}