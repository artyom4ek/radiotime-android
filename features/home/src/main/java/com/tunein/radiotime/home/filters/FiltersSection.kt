package com.tunein.radiotime.home.filters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.GridItem

@Composable
fun FiltersSection(filters: List<GridItem>?, onClick: (String) -> Unit) {
    if (filters == null) {
        return
    }

    Column {
        Text(
            text = stringResource(id = R.string.filters),
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(id = R.string.feel_the_world),
            fontSize = 16.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.size(15.dp))
        FiltersList(items = filters, onClick = onClick)
    }
}