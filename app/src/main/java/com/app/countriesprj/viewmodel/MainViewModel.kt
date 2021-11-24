package com.app.countriesprj.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.countriesprj.model.CountriesModel
import com.app.countriesprj.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<CountriesModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCountries() {

        val response = repository.getAllCountries()
        response.enqueue(object : Callback<List<CountriesModel>> {
            override fun onResponse(call: Call<List<CountriesModel>>, response: Response<List<CountriesModel>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountriesModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}