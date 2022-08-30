package com.example.basic_mvvm.DI

import com.example.basic_mvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [Network_Module::class])
@Singleton
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}