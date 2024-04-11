package com.aerc.kotlinexpert.remote

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val notesClient = HttpClient(OkHttp){
    install(ContentNegotiation){
        json()
    }

}
