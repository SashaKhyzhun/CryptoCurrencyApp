package com.sashakhyzhun.cryptocurrencyapp.rest

import com.sashakhyzhun.cryptocurrencyapp.model.Currency
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * @author SashaKhyzhun
 * Created on 12/17/17.
 */
interface CryptoCurrency {

    @GET("v1/ticker/")
    fun getNewData(): Observable<List<Currency>>

    companion object Factory {
        fun create(): CryptoCurrency {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()) // tell how to parse
                    .baseUrl("https://api.coinmarketcap.com/") // main part of the link
                    .build()

            return retrofit.create(CryptoCurrency::class.java)
        }
    }
}