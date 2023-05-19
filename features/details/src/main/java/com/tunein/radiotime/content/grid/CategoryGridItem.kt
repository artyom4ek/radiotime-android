package com.tunein.radiotime.content.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.GridItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryGridItem(categoryItem: GridItem, onClick: (String, AudioItem?) -> Unit) {
    Card(
        modifier = Modifier.size(120.dp),
        onClick = { onClick(categoryItem.url, null) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = categoryItem.title,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Clip,
                textAlign = TextAlign.Center
            )
        }
    }
}