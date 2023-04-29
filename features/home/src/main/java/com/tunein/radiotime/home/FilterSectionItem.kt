package com.tunein.radiotime.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.home.model.FilterItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSectionItem(item: FilterItem, onClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(0),
        modifier = Modifier.height(50.dp),
        onClick = { onClick(item.url) }) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.padding(10.dp),
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.primary
                ),
                painter = painterResource(id = item.icon),
                contentDescription = item.title
            )
            Text(
                modifier = Modifier.weight(1f),
                text = item.title,
                fontSize = 16.sp
            )
            Image(
                modifier = Modifier.padding(10.dp),
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.primary
                ),
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Arrow"
            )
        }
    }
}

@Preview
@Composable
fun FilterSectionItemPreview() {
    FilterSectionItem(item = provideFilterItems()[0], onClick = {})
}