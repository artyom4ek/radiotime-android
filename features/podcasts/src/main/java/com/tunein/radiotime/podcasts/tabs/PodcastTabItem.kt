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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.CategoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastTabItem(item: CategoryItem, onClick: (String) -> Unit) {
    Card(modifier = Modifier.size(120.dp), onClick = { onClick(item.url) }) {
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
            item.count?.let {
                Text(
                    text = stringResource(id = R.string.items_count, it),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}