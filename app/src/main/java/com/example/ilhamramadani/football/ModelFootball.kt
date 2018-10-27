package com.example.ilhamramadani.football

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelFootball (val club : String, val logo : Int ,val detail : String ) : Parcelable