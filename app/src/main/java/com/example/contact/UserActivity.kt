package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val image:Int = intent.getIntExtra("ImageId",0)
        val name: String? = intent.getStringExtra("Name")
        val phonenumber: String? = intent.getStringExtra("PhoneNumber")

        user_imge.setImageResource(image)
        user_name.text=name
        user_number.text=phonenumber
    }
}