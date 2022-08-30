package com.example.basic_mvvm.DI

import com.example.basic_mvvm.Model.BASE_URL
import com.example.basic_mvvm.Retrofit.FakerApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class Network_Module {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton

    fun providesFakerAPI(retrofit: Retrofit):FakerApi{
        return retrofit.create(FakerApi::class.java)
    }
}