package com.example.tokoonline

import com.example.tokoonline.model.Produk
import retrofit2.Call
import retrofit2.http.GET

interface Api_Interface {
    @GET("api/v1/register")
    fun getCEOS(): Call<ArrayList<Produk>>
}