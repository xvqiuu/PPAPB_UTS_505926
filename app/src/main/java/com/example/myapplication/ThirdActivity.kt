package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    //membuat binding terlebih dahulu
    private lateinit var binding: ActivityThirdBinding

    private var selectedDate : String = ""
    private lateinit var currentweightt : Array<String>
    private lateinit var wantweightt : Array<String>
    private lateinit var purposed : Array<String>

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_CURRENTWEIGHT = "extra_currentweight"
        const val EXTRA_WEIGHTWANT = "extra_weightwant"
        const val EXTRA_PURPOSE = "extra_purpose"
        const val EXTRA_TARGETMAXCAL = "extra_targetmaxcal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting bindingnya
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentweightt = resources.getStringArray(R.array.unitofweight);
        wantweightt = resources.getStringArray(R.array.unitofweight);
        purposed = resources.getStringArray(R.array.purpose);

        with(binding) {
            btnNextt.setOnClickListener{
                val intentToFourthActivity = Intent(this@ThirdActivity, FourthActivity::class.java)

                //memanggil data di activity 3
                val name = inputName.text.toString()
                intentToFourthActivity.putExtra(EXTRA_NAME,name)

                val currentweight = edittextCurrent.toString()
                intentToFourthActivity.putExtra(EXTRA_CURRENTWEIGHT,currentweight)

                val weightwant = edittextWantweight.toString()
                intentToFourthActivity.putExtra(EXTRA_WEIGHTWANT,weightwant)

                val purpose = spinnerPurpose.selectedItem.toString()
                intentToFourthActivity.putExtra(EXTRA_PURPOSE,purpose)

                val targetmaxcal = inputTargetmaxcal.toString()
                intentToFourthActivity.putExtra(EXTRA_TARGETMAXCAL,targetmaxcal)

                setResult(Activity.RESULT_OK,intentToFourthActivity)
                startActivity(intentToFourthActivity)
            }

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) {_, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear +1}/$year"
                Toast.makeText(this@ThirdActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            btnBack.setOnClickListener{
                val intentBackToSecondActivity = Intent(this@ThirdActivity,SecondActivity::class.java)
                startActivity(intentBackToSecondActivity)
            }
        }
    }
}