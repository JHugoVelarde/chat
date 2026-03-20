package com.example.chat.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chat.data.Message

@Composable
fun ChatBubble(message: Message, modifier: Modifier = Modifier) {
    val bubbleColor = if (message.isMine) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
    val textColor = if (message.isMine) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
    val alignment = if (message.isMine) Alignment.CenterEnd else Alignment.CenterStart

    val bubbleShape = if (message.isMine) {
        RoundedCornerShape(16.dp, 16.dp, 0.dp, 16.dp)
    } else {
        RoundedCornerShape(16.dp, 16.dp, 16.dp, 0.dp)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        contentAlignment = alignment
    ) {
        Column(horizontalAlignment = if (message.isMine) Alignment.End else Alignment.Start) {
            if (!message.isMine) {
                Text(
                    text = message.author,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )
            }
            Surface(
                color = bubbleColor,
                shape = bubbleShape,
                shadowElevation = 1.dp
            ) {
                Text(
                    text = message.content,
                    color = textColor,
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = message.timestamp,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 4.dp, end = 4.dp, start = 4.dp)
            )
        }
    }
}