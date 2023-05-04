package com.tunein.radiotime.home.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.domain.model.CategoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverGridItem(categoryItem: CategoryItem, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier.size(120.dp),
        onClick = { onClick(categoryItem.url) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            categoryItem.icon?.let {
                Image(
                    painterResource(id = it),
                    modifier = Modifier.size(36.dp),
                    colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    contentDescription = categoryItem.title,
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = categoryItem.title, fontSize = 16.sp)
            Text(text = "10 items", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
        }
    }
}