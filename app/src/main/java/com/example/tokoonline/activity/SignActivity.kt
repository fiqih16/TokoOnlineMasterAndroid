package com.example.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tokoonline.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign.*

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        btn_daftar.setOnClickListener{
            val intent = Intent ( this , RegisterActivity::class.java)
            startActivity(intent)
            Toast.makeText(this , "Welcome Register" , Toast.LENGTH_SHORT).show()
        }
    }
}