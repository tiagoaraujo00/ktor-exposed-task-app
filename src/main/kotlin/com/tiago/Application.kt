package com.tiago

import com.example.plugins.configureSerialization
import com.tiago.plugins.configureDatabases
import com.tiago.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val repository = com.tiago.model.FakeTaskRepository()
    configureSerialization(repository)
    configureDatabases()
    configureRouting()
}
