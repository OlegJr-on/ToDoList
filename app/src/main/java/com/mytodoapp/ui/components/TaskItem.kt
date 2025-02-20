package com.mytodoapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskItem(task: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "•", // Bullet point
                fontSize = 22.sp,
                modifier = Modifier.padding(end = 8.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = task,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
