package com.aerc.kotlinexpert.data

sealed interface Filter {
    object All : Filter
    class ByType(val type: Note.Type) : Filter
}
