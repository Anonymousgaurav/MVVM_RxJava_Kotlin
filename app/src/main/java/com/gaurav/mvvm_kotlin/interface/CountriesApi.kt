package com.gaurav.mvvm_kotlin.`interface`

import com.gaurav.mvvm_kotlin.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountriesApi
{

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries() : Single<List<Country>>

}