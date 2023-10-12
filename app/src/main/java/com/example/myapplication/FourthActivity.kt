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
import com.example.myapplication.FifthActivity.Companion.EXTRA_REMAINCALORY
import com.example.myapplication.FifthActivity.Companion.EXTRA_TOTALCAL
import com.example.myapplication.FifthActivity.Companion.EXTRA_WORKOUTDURATION
import com.example.myapplication.FifthActivity.Companion.EXTRA_WORKOUTNAME
import com.example.myapplication.FifthActivity.Companion.EXTRA_WORKOUTTIME
import com.example.myapplication.ThirdActivity.Companion.EXTRA_CURRENTWEIGHT
import com.example.myapplication.ThirdActivity.Companion.EXTRA_NAME
import com.example.myapplication.ThirdActivity.Companion.EXTRA_TARGETMAXCAL
import com.example.myapplication.ThirdActivity.Companion.EXTRA_PURPOSE
import com.example.myapplication.ThirdActivity.Companion.EXTRA_WEIGHTWANT
import com.example.myapplication.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    //membuat binding terlebih dahulu
    private lateinit var binding: ActivityFourthBinding

    //buat memanggil activity input data
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

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
                val remaincalory = data?.getStringExtra(EXTRA_REMAINCALORY)

                val name = data?.getStringExtra(EXTRA_NAME)
                val currentweight = data?.getStringExtra(EXTRA_CURRENTWEIGHT)
                val weightwant = data?.getStringExtra(EXTRA_WEIGHTWANT)
                val purpose = data?.getStringExtra(EXTRA_PURPOSE)
                val targetmaxcal = data?.getStringExtra(EXTRA_TARGETMAXCAL)

                binding.detailview.text = "Nama $name, berat badan saat ini $currentweight, berat badan yang diinginkan $weightwant, tujuan $purpose, target kalori maksimal $targetmaxcal."
                binding.detailview1.text = "Nama makanan $foodname$workoutname, waktu makan $foodtime$workouttime, jenis kalorin In $caltypein$workoutduration, dan jumlah kalori $totalcal$burncal."
                binding.viewRemaincalory.text = "$remaincalory kkal"
                binding.viewConsumcalory.text = "$totalcal$burncal kkal"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting bindingnya
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            detailview.text = " "
            detailview1.text = " "
            viewRemaincalory.text = " "
            viewConsumcalory.text = " "

            btnToinput.setOnClickListener {
                val intent = Intent(this@FourthActivity, FifthActivity::class.java)

                launcher.launch(intent)
            }
            btnBackk.setOnClickListener {
                val intentBackToThirdActivity =
                    Intent(this@FourthActivity, ThirdActivity::class.java)
                startActivity(intentBackToThirdActivity)
            }

        }
    }
}


