package com.tunein.radiotime.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.R

@Composable
fun StationsSectionTop(itemsCount: Int = 0) {
    Column {
        Text(
            text = stringResource(id = R.string.local_stations),
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(id = R.string.items_count, itemsCount),
            color = Color.DarkGray,
            fontSize = 16.sp
        )
    }
    Spacer(modifier = Modifier.size(15.dp))
}

@Preview
@Composable
fun StationsSectionTopPreview() {
    StationsSectionTop()
}