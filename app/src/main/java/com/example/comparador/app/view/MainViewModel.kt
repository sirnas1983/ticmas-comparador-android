package com.example.comparador.app.view
import com.example.comparador.app.model.Texts
import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {

    fun compare(texts : Texts) : Boolean{
        return texts.text1 == texts.text2
    }
}