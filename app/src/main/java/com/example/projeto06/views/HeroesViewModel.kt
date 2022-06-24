package com.example.projeto06.views

import android.util.Log
import androidx.lifecycle.*
import com.example.projeto06.data.domain.Hero
import com.example.projeto06.data.repository.HeroRepository
import com.example.projeto06.data.source.OpenDotaApi
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.IllegalArgumentException

class HeroesViewModel(private val repository: HeroRepository) : ViewModel() {

    init {
        if(repository.heroes.value.isNullOrEmpty()){
            refreshDataFromRepository()
        }
    }

    val heroes = repository.heroes

    private val _eventNetworkError = MutableLiveData<String>("")

    private fun refreshDataFromRepository(){
        viewModelScope.launch {
            try {
                repository.refreshHeroes()
                _eventNetworkError.value = ""
            }catch (networkError: IOException){
                Log.d("Error", "${networkError.message}")
                _eventNetworkError.value = networkError.message
            }
        }


    }



}

class HeroVMFactory(private val repository: HeroRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HeroesViewModel::class.java))
            return HeroesViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}