package com.example.comparador.app.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.comparador.R
import com.example.comparador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            compare()
        }

    }

    private fun compare(){

        mainViewModel.text1.text = binding.text1.text.toString()
        mainViewModel.text2.text = binding.text2.text.toString()

        val textResult = binding.responseText

        if (mainViewModel.compare()){
            textResult.setTextColor(Color.parseColor("#000000"))
            textResult.setBackgroundColor(Color.parseColor("#80f369"))
            textResult.text = getString(R.string.response_text_true)
        } else {
            textResult.setBackgroundColor(Color.parseColor("#D90900"))
            textResult.setTextColor(Color.parseColor("#FFFFFF"))
            textResult.text = getString(R.string.response_text_false)
        }
    }
}