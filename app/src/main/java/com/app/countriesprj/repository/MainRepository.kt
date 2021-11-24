package com.app.countriesprj.repository

import com.app.countriesprj.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCountries() = retrofitService.getAllCountries()
}