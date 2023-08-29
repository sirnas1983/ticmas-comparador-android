package com.example.comparador.app.view

import com.example.comparador.app.model.Texts
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.comparador.R
import com.example.comparador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var text1 : String = ""
    private var text2 : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            compare()
        }

    }

    private fun compare(){
        text1 = binding.text1.text.toString()
        text2 = binding.text2.text.toString()
        val texts = Texts(text1, text2)

        val textResult = binding.responseText

        if (mainViewModel.compare(texts)){
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