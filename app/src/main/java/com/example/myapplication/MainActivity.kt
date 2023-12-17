package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifeCycle"

    //membuat binding terlebih dahulu
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan Handler untuk menampilkan splash screen selama beberapa detik
        Handler().postDelayed({
            // Setelah beberapa detik, pindah ke aktivitas selanjutnya
            val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intentToSecondActivity)

        }, 3000) // Delay selama 3 detik (sesuai kebutuhan Anda)

        Log.d(TAG, "inCreate dipanggil")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy dipanggil")
    }
}