package com.example.chat.data

data class Message(
    val author: String,
    val content: String,
    val timestamp: String,
    val isMine: Boolean
)

object FakeChatData {
    val messages = listOf(
        Message("Hugo", "¿Listos para lanzar la nueva app?", "10:00 AM", true),
        Message("Ana", "Casi, solo revisando las animaciones en el Canvas.", "10:05 AM", false),
        Message("Hugo", "Perfecto. Avísame cuando el PR esté listo para revisarlo.", "10:06 AM", true)
    )
}