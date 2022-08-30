package com.example.basic_mvvm

import android.app.Application
import com.example.basic_mvvm.DI.ApplicationComponent
import com.example.basic_mvvm.DI.DaggerApplicationComponent

class MyApplication:Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent=DaggerApplicationComponent.builder().build()

    }
}