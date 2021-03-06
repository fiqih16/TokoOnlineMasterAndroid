package com.example.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tokoonline.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_Login.setOnClickListener {
            val intent = Intent (this,SignActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Sign IN " , Toast.LENGTH_SHORT).show()
        }
        btn_register.setOnClickListener{
            val intent = Intent ( this , RegisterActivity::class.java)
            startActivity(intent)
            Toast.makeText(this , "Welcome Register" , Toast.LENGTH_SHORT).show()
        }
    }
}