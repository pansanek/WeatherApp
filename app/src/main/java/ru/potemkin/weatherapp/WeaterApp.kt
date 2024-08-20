package ru.potemkin.weatherapp

import android.app.Application
import ru.potemkin.weatherapp.di.ApplicationComponent
import ru.potemkin.weatherapp.di.DaggerApplicationComponent

class WeaterApp:Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}