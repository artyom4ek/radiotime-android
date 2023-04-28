package com.tunein.radiotime.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R

@Composable
fun DiscoverSection(categories: List<Category>, onClick: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.discover),
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(id = R.string.find_your_mood),
            fontSize = 16.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.size(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DiscoverGrid(categories, onClick)
        }
    }
}

@Composable
fun DiscoverGrid(categories: List<Category>, onClick: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { category ->
            DiscoverGridItem(category, onClick)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverGridItem(category: Category, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp),
        onClick = { onClick("URL") }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = category.icon),
                modifier = Modifier.size(36.dp),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = category.title, fontSize = 16.sp)
            Text(text = "10 items", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Preview
@Composable
fun DiscoverSectionPreview() {
    DiscoverSection(categories = provideDiscoverCategories(), onClick = {})
}