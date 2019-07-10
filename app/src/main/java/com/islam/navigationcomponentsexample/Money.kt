package com.islam.navigationcomponentsexample

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
@SuppressLint("ParcelCreator")
data class Money(val amount: BigDecimal): Parcelable