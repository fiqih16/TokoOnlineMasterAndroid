package com.example.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tokoonline.R
import com.example.tokoonline.api.ApiClient
import com.example.tokoonline.api.ApiService
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
//            val intent = Intent ( this , RegisterActivity::class.java)
//            startActivity(intent)
//            Toast.makeText(this , "Berhasil Daftar" , Toast.LENGTH_SHORT).show()
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
        //val pass_confirm = et_confirm_password.text.toString()

        if (name == "" || email == "" || password == ""){
            Toast.makeText(this,
                "Masih ada kolom yang kosong", Toast.LENGTH_LONG).show()
        }else{
            val newUser : UserModel = UserModel(null,name,email,password)

            var apiInterface: ApiService = ApiClient().getApiClient()!!.create(ApiService::class.java)
            var requestCall : Call<UserModel> = apiInterface.regisUser(newUser)

            requestCall.enqueue(object : Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@RegisterActivity,
                            "Berhasil tersimpan", Toast.LENGTH_LONG).show()
//                        setupListOfDataIntoRecyclerView()
//                        et_username.setText("")
//                        et_regisEmail.setText("")
//                        et_regisPassword.setText("")
//                        et_confirm_password.setText("")
                    }else{
                        Toast.makeText(this@RegisterActivity,
                            "Gagal tersimpan", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity,
                    "Gagal tersimpan", Toast.LENGTH_LONG).show()
                }

            })
        }

    }

}