package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    //membuat binding terlebih dahulu
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting bindingnya
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener{
            val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)

            startActivity(intentToThirdActivity)
        }
    }
}