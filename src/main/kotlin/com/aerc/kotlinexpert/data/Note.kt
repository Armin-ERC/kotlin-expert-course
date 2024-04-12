package com.aerc.kotlinexpert.data

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id : Long = NEW_NOTE,
    val title: String,
    val description: String,
    val type: Type
) {

    companion object{
        const val NEW_NOTE = -1L
    }

    enum class Type {
        TEXT, AUDIO
    }
}
