package com.example.bmitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmitest.databinding.ActivityMainBinding

        private lateinit var binding: ActivityMainBinding

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCal.setOnClickListener{
            val h : Float = binding.edt1.text.toString().toFloat() /100
            val w : Float = binding.edt2.text.toString().toFloat()
            if (h.toString().isNotEmpty() && w.toString().isNotEmpty()) {
                caculateBMI(h,w)
            } else {
               Toast.makeText(this,"กรุณากรอกให้ครบทุกช่อง!", Toast.LENGTH_SHORT).show()
            }
        }
        }

    }
        private  fun  caculateBMI (h : Float,w : Float) {
            val bmi : Float = w/(h*h)
            bmiStatus(bmi)
            binding.txtResult.text = ("%.2f".format(bmi))
            binding.txtStatus.text = bmiStatus(bmi)
        }
        private fun bmiStatus(bmi: Float) :String {
            lateinit var bmistatus: String
            if (bmi < 18.5) {
                bmistatus = "underrated"
            } else if (bmi >= 18.5 && bmi < 25) {
                bmistatus = "normal"
            } else if (bmi >= 25 && bmi<30) {
                bmistatus = "overweight"
            } else if (bmi > 30) {
                bmistatus = "Obesity"
            }
            return bmistatus

        }


