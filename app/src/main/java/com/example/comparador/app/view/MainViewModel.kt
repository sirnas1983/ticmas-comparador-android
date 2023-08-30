package com.example.comparador.app.view
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.comparador.app.model.Text


class MainViewModel : ViewModel() {

    val text1 = MutableLiveData<Text>(Text(""))
    val text2 = MutableLiveData<Text>(Text(""))
    fun compare() : Boolean{
        return text1.value?.text == text2.value?.text
    }
}