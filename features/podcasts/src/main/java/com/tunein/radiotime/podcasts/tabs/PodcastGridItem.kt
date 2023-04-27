package com.tunein.radiotime.podcasts.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.podcasts.model.CategoryItem
import com.tunein.radiotime.podcasts.provideMusicCategories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastGridItem(item: CategoryItem, onClick: (Int) -> Unit) {
    Card(modifier = Modifier.size(120.dp), onClick = { onClick(item.id) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.title,
                fontSize = 15.sp,
                maxLines = 2,
                overflow = TextOverflow.Clip,
                textAlign = TextAlign.Center
            )
            Text(
                text = "${item.itemsCount} items",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    PodcastGridItem(item = provideMusicCategories()[0], onClick = {})
}