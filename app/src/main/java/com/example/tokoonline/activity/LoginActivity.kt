package com.example.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokoonline.R
import com.example.tokoonline.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btn_prosesLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}