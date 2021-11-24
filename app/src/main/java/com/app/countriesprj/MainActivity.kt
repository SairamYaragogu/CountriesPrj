package com.app.countriesprj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.countriesprj.adapter.CountriesAdapter
import com.app.countriesprj.databinding.ActivityMainBinding
import com.app.countriesprj.repository.MainRepository
import com.app.countriesprj.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = CountriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setCountryList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })

        binding.btnFetch.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                viewModel.getAllCountries()
            }
        })
    }
}