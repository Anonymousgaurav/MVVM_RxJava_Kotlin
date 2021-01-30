package com.gaurav.mvvm_kotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaurav.mvvm_kotlin.R
import kotlinx.android.synthetic.main.item_country.*

import com.gaurav.mvvm_kotlin.model.Country
import com.gaurav.mvvm_kotlin.utils.getProgressDrawable
import com.gaurav.mvvm_kotlin.utils.loadImage
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(var countries: ArrayList<Country>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val countryName = itemView.countryName
        private val imageView = itemView.imageView
        private val countryCapital = itemView.capital
        private val progressDrawable = getProgressDrawable(itemView.context)



        fun bind(country: Country) {

            countryName.text = country.countryName
            countryCapital.text = country.capital
            imageView.loadImage(country.flag, progressDrawable)

        }

    }

}