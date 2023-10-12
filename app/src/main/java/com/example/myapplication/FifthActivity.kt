package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ThirdActivity.Companion.EXTRA_TARGETMAXCAL
import com.example.myapplication.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding
    private lateinit var caltypedd :Array<String>

    companion object {
        const val EXTRA_FOODNAME = "extra_foodname"
        const val EXTRA_FOODTIME = "extra_foodtime"
        const val EXTRA_CALTYPEIN = "extra_caltypein"
        const val EXTRA_TOTALCAL = "extra_totalcal"
        const val EXTRA_WORKOUTNAME = "extra_workoutname"
        const val EXTRA_WORKOUTTIME = "extra_workouttime"
        const val EXTRA_WORKOUTDURATION = "extra_workoutduration"
        const val EXTRA_BURNCAL = "extra_burncal"
        const val EXTRA_REMAINCALORY = "extra_remaincalory"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting bindingnya
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        caltypedd = resources.getStringArray(R.array.caltyped)

        with(binding) {

            val adapterCalTyped = ArrayAdapter(
                this@FifthActivity,
                android.R.layout.simple_spinner_item,
                caltypedd
            )
            adapterCalTyped.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            spinnerCaltype.adapter = adapterCalTyped

            //memilih jenis kalori
            spinnerCaltype.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {

                        val selectedItem = spinnerCaltype.selectedItem.toString()
                        if (selectedItem == "Kalori In") {
                            //Mengontrol apakah sebuah View (tampilan) akan terlihat atau tersembunyi di layar
                            showTypecalin.visibility = View.VISIBLE
                            showTypecalout.visibility = View.GONE
                        }
                        else if (selectedItem == "Kalori Out") {
                            showTypecalin.visibility = View.GONE
                            showTypecalout.visibility = View.VISIBLE
                        }
                        else {
                            showTypecalin.visibility = View.GONE
                            showTypecalout.visibility = View.GONE
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        // Metode ini akan dipanggil jika tidak ada item yang dipilih
                    }
                }
            btnSave.setOnClickListener {
                val intentToFourthActivity = Intent(this@FifthActivity, FourthActivity::class.java)

                val remaincalory = edittextTarget.text.toString()
                intentToFourthActivity.putExtra(EXTRA_REMAINCALORY,remaincalory)
                //Kalori In
                val foodname = edittextName.text.toString()
                intentToFourthActivity.putExtra(EXTRA_FOODNAME, foodname)

                val foodtime = edittextFoodtime.text.toString()
                intentToFourthActivity.putExtra(EXTRA_FOODTIME, foodtime)

                val caltypein = spinnerTypecalin.selectedItem.toString()
                intentToFourthActivity.putExtra(EXTRA_CALTYPEIN, caltypein)

                val totalcal = edittextCountcal.text.toString()
                intentToFourthActivity.putExtra(EXTRA_TOTALCAL, totalcal)

                //Kalori Out
                val workoutname = edittextNameworkout.text.toString()
                intentToFourthActivity.putExtra(EXTRA_WORKOUTNAME, workoutname)

                val workouttime = edittextWorkouttime.text.toString()
                intentToFourthActivity.putExtra(EXTRA_WORKOUTTIME, workouttime)

                val workoutduration = edittextWorkoutduration.text.toString()
                intentToFourthActivity.putExtra(EXTRA_WORKOUTDURATION, workoutduration)

                val burncal = edittextBurncal.text.toString()
                intentToFourthActivity.putExtra(EXTRA_BURNCAL, burncal)

                setResult(Activity.RESULT_OK,intentToFourthActivity)
                finish()
            }
            btnBacktohome.setOnClickListener {
                val intentBackToFourthActivity =
                    Intent(this@FifthActivity, FourthActivity::class.java)
                startActivity(intentBackToFourthActivity)
            }

        }
    }
}

