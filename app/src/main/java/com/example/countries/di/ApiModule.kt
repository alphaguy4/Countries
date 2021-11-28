package com.example.countries.di

import com.example.countries.model.CountriesApi
import com.example.countries.model.CountriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://raw.githubusercontent.com"

    @Provides
    fun provideCountriesApi(): CountriesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // transform json to data class to  kotlin code
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // transform data class Country to observable
            .build()
            .create(CountriesApi::class.java)
    }

    @Provides
    fun providesCountriesService(): CountriesService {
        return CountriesService()
    }
}