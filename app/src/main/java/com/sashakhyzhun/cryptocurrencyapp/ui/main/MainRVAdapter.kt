package com.sashakhyzhun.cryptocurrencyapp.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sashakhyzhun.cryptocurrencyapp.R
import com.sashakhyzhun.cryptocurrencyapp.model.Currency
import com.sashakhyzhun.cryptocurrencyapp.util.getDrawableId
import kotlinx.android.synthetic.main.item_currency.view.*

/**
 * @author SashaKhyzhun
 * Created on 12/17/17.
 */
class MainRVAdapter(private val result: List<Currency>,
                    private var resources: Resources,
                    private val ctx: Context) : RecyclerView.Adapter<MainRVAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_currency, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currency: Currency = result[position]

        holder.itemView.imageView.setImageResource(getDrawableId(currency.symbol!!, ctx))
        holder.itemView.symbol.text = currency.symbol
        holder.itemView.name.text = currency.name
        holder.itemView.money.text = currency.priceUsd + "$"
        holder.itemView.hours.text = currency.percentChange24h + "%"
        holder.itemView.days.text = currency.percentChange7d + "%"


        holder.itemView.hours.setTextColor(getTextColor(currency.percentChange24h!!.toFloat(), resources))
        holder.itemView.days.setTextColor(getTextColor(currency.percentChange7d!!.toFloat(), resources))

    }

    override fun getItemCount(): Int = result.size


    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private fun getTextColor(value: Float, resources: Resources): Int =
            if (value > 0.0) resources.getColor(R.color.green)
            else resources.getColor(R.color.red)

}