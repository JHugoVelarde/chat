package com.example.chat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chat.data.FakeChatData
import com.example.chat.data.Message
import com.example.chat.ui.components.ChatBubble
import com.example.chat.ui.components.ConversationTopBar
import com.example.chat.ui.components.MessageInput
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ConversationScreen(modifier: Modifier = Modifier) {
    val messages = remember { mutableStateListOf(*FakeChatData.messages.reversed().toTypedArray()) }
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(0)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize().imePadding(),
        contentWindowInsets = WindowInsets.systemBars.union(WindowInsets.ime),
        topBar = {
            ConversationTopBar(chatName = "Ana")
        },
        bottomBar = {
            MessageInput(
                onMessageSent = { text ->
                    val time = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
                    messages.add(0, Message("Hugo", text, time, true))
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            reverseLayout = true,
            contentPadding = PaddingValues(top = 16.dp, bottom = 8.dp)
        ) {
            items(messages) { message ->
                ChatBubble(message = message)
            }
        }
    }
}