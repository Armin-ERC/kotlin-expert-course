package com.aerc.kotlinexpert.data

import com.aerc.kotlinexpert.data.Note.Type
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

data class Note(
    val title: String,
    val description: String,
    val type: Type
) {
    enum class Type {
        TEXT, AUDIO
    }
}

fun getNotes() = flow {
    delay(2000)

    val notes = (1..10).map {
        Note(
            title = "Title $it", description = "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )
    }
    emit(notes)
}
