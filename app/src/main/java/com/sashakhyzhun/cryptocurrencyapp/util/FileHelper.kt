package com.sashakhyzhun.cryptocurrencyapp.util

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable

/**
 * @author SashaKhyzhun
 * Created on 12/17/17.
 */

@Throws(Resources.NotFoundException::class)
fun getDrawableImage(title: String, context: Context): Drawable {
    return context.resources
            .getDrawable(context.resources
                    .getIdentifier(title, "drawable", context.packageName), null)
}

@Throws(Resources.NotFoundException::class)
fun getDrawableId(title: String, context: Context): Int {
    return context.resources
            .getIdentifier(title.toLowerCase(), "drawable", context.packageName)
}