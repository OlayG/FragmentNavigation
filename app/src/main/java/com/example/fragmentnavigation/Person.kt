package com.example.fragmentnavigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Annotation that allows the Parcelable Implementation to be generated
@Parcelize
data class Person(
    val name: String,
    val age: Int
) : Parcelable // Parcelable allows us to pass this custom class in Intents, Bundles
// etc.. It is faster that Serializable because it doesn't use reflection and it was
// made for android os