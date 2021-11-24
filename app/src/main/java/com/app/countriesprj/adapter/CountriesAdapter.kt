package com.app.countriesprj.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.countriesprj.databinding.CountriesItemRowBinding
import com.app.countriesprj.model.CountriesModel

class CountriesAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var countries = mutableListOf<CountriesModel>()

    fun setCountryList(movies: List<CountriesModel>) {
        this.countries = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = CountriesItemRowBinding.inflate(inflater,parent,false);
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val country = countries[position]
        holder.binding.tvCountryID.text = country.id
        holder.binding.tvCountryName.text = country.countryName
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}

class MainViewHolder(val binding: CountriesItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

}