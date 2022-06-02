package com.example.projeto06.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto06.data.Hero
import com.example.projeto06.network.OpenDotaApi
import kotlinx.coroutines.launch

class HeroesViewModel : ViewModel() {

    private val _heroList = MutableLiveData<List<Hero>>()
    val heroList: LiveData<List<Hero>>
        get() = _heroList

    init {
        getHeroes()
    }

    private fun getHeroes(){
        viewModelScope.launch {
            try {
                val listResult = OpenDotaApi.retrofitService.getHeroes()
                _heroList.value = listResult
            }catch (e: Exception){
                _heroList.value = null
                Log.d("GetHeroes","${e.message}")
            }
        }
    }
}