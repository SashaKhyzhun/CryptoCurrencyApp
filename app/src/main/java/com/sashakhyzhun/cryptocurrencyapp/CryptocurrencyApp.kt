package com.sashakhyzhun.cryptocurrencyapp

import android.app.Application
import timber.log.Timber

/**
 * @author SashaKhyzhun
 * Created on 12/17/17.
 */

class CryptocurrencyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}
