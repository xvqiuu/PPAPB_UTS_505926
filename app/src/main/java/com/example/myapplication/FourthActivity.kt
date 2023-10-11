package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.FifthActivity.Companion.EXTRA_BURNCAL
import com.example.myapplication.FifthActivity.Companion.EXTRA_CALTYPEIN
import com.example.myapplication.FifthActivity.Companion.EXTRA_FOODNAME
import com.example.myapplication.FifthActivity.Companion.EXTRA_FOODTIME
import com.example.myapplication.FifthActivity.Companion.EXTRA_TOTALCAL
import com.example.myapplication.FifthActivity.Companion.EXTRA_WORKOUTDURATION
import com.example.myapplication.FifthActivity.Companion.EXTRA_WORKOUTNAME
import com.example.myapplication.FifthActivity.Companion.EXTRA_WORKOUTTIME
import com.example.myapplication.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    //membuat binding terlebih dahulu
    private lateinit var binding: ActivityFourthBinding

    //buat memanggil activity inout data
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //update txtName dengan alamat dari activity yg ke 3
                result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val foodname = data?.getStringExtra(EXTRA_FOODNAME)
                val foodtime = data?.getStringExtra(EXTRA_FOODTIME)
                val caltypein= data?.getStringExtra(EXTRA_CALTYPEIN)
                val totalcal = data?.getStringExtra(EXTRA_TOTALCAL)
                val workoutname = data?.getStringExtra(EXTRA_WORKOUTNAME)
                val workouttime = data?.getStringExtra(EXTRA_WORKOUTTIME)
                val workoutduration = data?.getStringExtra(EXTRA_WORKOUTDURATION)
                val burncal = data?.getStringExtra(EXTRA_BURNCAL)

                binding.detailview.text = "Nama Makanan $foodname pada $foodtime dengan jenis $caltypein dan jumlah $totalcal"
                binding.detailview.text = "Nama Workout $workoutname pada $workouttime dengan jenis $workoutduration dan jumlah $burncal"

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting bindingnya
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            detailview.text = " "

            btnToinput.setOnClickListener {
                val intent = Intent(this@FourthActivity, FifthActivity::class.java)

                launcher.launch(intent)
            }
            btnBackk.setOnClickListener {
                val intentBackToSecondActivity =
                    Intent(this@FourthActivity, ThirdActivity::class.java)
                startActivity(intentBackToSecondActivity)
            }

        }
    }
}

