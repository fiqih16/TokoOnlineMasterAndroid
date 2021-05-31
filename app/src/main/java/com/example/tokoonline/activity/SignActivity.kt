package com.example.tokoonline.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.tokoonline.MainActivity
import com.example.tokoonline.R
import com.example.tokoonline.api.ApiClient
import com.example.tokoonline.api.ApiService
import com.example.tokoonline.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_sign.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignActivity : AppCompatActivity() {
    lateinit var  sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        btn_daftar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Welcome Register", Toast.LENGTH_SHORT).show()
        }

        btn_sign_in.setOnClickListener{
            loginMasuk()
        }
    }

        fun loginMasuk() {
            val Uname   = et_email.text.toString()
            val Upass   = et_password.text.toString()



            if (Uname.isEmpty() || Upass.isEmpty()){
                Toast.makeText(this, "Isikan Username atau Password Dahulu !", Toast.LENGTH_SHORT).show()
            } else {

                var apiInterface: ApiService = ApiClient().getApiClient()!!.create(ApiService::class.java)
                var requestCall: Call<LoginResponse> = apiInterface.login(Uname, Upass)
                requestCall.enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(baseContext, "Gagal Masuk "+t.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        // untuk menyimpan data sementara di sharedPrefence
                        if(response.isSuccessful){
                            Log.d("log", response.body()?.token.toString())
                            val token: String = response.body()?.token.toString()
                            sharedPref = getSharedPreferences("SharePref", MODE_PRIVATE)
                            val editor: SharedPreferences.Editor = sharedPref.edit()
                            editor.putString("token", token)
                            editor.apply()
                            Toast.makeText(this@SignActivity, "Login Sukses!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignActivity, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@SignActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                        }
                    }

                })

            }
        }
}