package com.example.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tokoonline.MainActivity
import com.example.tokoonline.R
import com.example.tokoonline.api.ApiClient
import com.example.tokoonline.api.ApiService
import com.example.tokoonline.model.DefaultResponse
import com.example.tokoonline.model.UserModel
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_sign.*
import kotlinx.android.synthetic.main.activity_sign.btn_daftar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_masuk.setOnClickListener{
            val intent = Intent ( this , SignActivity::class.java)
            startActivity(intent)
            Toast.makeText(this , "Welcome Register" , Toast.LENGTH_SHORT).show()
        }

        btn_register.setOnClickListener {
            register()

        }

    }


    fun register(){
//        val request = UserModel()
//        request.name = et_username.text.toString().trim()
//        request.email = et_regisEmail.text.toString().trim()
//        request.password = et_regisPassword.text.toString().trim()
//        request.password_confirmation = et_confirm_password.text.toString().trim()
        val name = et_username.text.toString()
        val email = et_regisEmail.text.toString()
        val password = et_regisPassword.text.toString()
        val pass_confirm = et_confirm_password.text.toString()

        if(password != pass_confirm){
            return Toast.makeText(this,"Password tidak sesuai", Toast.LENGTH_SHORT).show()
        }
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,
                "Masih ada kolom yang kosong", Toast.LENGTH_LONG).show()
        }else{


            var apiInterface: ApiService = ApiClient().getApiClient()!!.create(ApiService::class.java)
            var requestCall : Call<DefaultResponse> = apiInterface.register(name, email,password)

            requestCall.enqueue(object : Callback<DefaultResponse>{
                override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@RegisterActivity,
                            "Berhasil Daftar", Toast.LENGTH_LONG).show()
                        Log.d("log", response.body()?.success.toString())
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@RegisterActivity,
                            "Gagal tersimpan", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                    Toast.makeText(baseContext,
                    "Gagal tersimpan" +t.toString(), Toast.LENGTH_LONG).show()
                }

            })
        }

    }

}