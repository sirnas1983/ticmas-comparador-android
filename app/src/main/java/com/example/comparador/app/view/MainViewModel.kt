package com.example.comparador.app.view
import androidx.lifecycle.ViewModel
import com.example.comparador.app.model.Text


class MainViewModel : ViewModel() {

    var text1 : Text = Text("")
    var text2 : Text = Text("")
    fun compare() : Boolean{
        return text1.text == text2.text
    }
}