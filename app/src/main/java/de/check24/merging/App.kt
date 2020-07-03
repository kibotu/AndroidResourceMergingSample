package de.check24.merging

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val runtimeConfig = RuntimeConfig()
        runtimeConfig.initFlipper()
    }
}