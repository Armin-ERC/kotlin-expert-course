import Note.Type
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
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

fun getNotes() : Flow<List<Note>> = flow {
    delay(2000)

    var notes = emptyList<Note>()

    (1..10).forEach {
        notes = notes + Note(
            title = "Title $it", description = "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )

        emit(notes)
        delay(500)
    }
}
