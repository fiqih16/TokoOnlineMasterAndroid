package com.example.tokoonline.api

import com.example.tokoonline.model.CategoryModel
import com.example.tokoonline.model.DefaultResponse
import com.example.tokoonline.model.LoginResponse
import com.example.tokoonline.model.UserModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<DefaultResponse>

    @GET("categories")
    fun getCategories(@Header("Authorization") authHeader:String): Call<CategoryModel>

    @GET("")
    fun getProductByCategory(@Header("Authorization") authHeader: String,
                             @Path("categoryId") id:Int): Call<JsonObject>
}
