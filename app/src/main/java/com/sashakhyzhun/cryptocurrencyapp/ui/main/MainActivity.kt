package com.sashakhyzhun.cryptocurrencyapp.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sashakhyzhun.cryptocurrencyapp.R
import com.sashakhyzhun.cryptocurrencyapp.model.Currency
import com.sashakhyzhun.cryptocurrencyapp.rest.CryptoCurrency
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doRequest()
    }

    private fun doRequest() {
        val apiService = CryptoCurrency.create()
        apiService.getNewData()
                .observeOn(AndroidSchedulers.mainThread()) // tell the observer on which thread to return data
                .subscribeOn(Schedulers.io()) // Select IO - to work with data and internet
                .subscribe({
                    result -> arrayListInit(result) // callback is here
                }, { error ->
                    Timber.e(error)
                }, {
                    Timber.d(":: onComplete!")
                })
    }

    private fun arrayListInit(result: List<Currency>) {
        recyclerView.adapter = MainRVAdapter(result, resources, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}
