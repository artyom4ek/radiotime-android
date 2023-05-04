package com.tunein.radiotime.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.CategoryItem

@Composable
fun FilterSection(items: List<CategoryItem>?, onClick: (String) -> Unit) {
    items?.let { filterCategories ->
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.filter),
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = stringResource(id = R.string.feel_the_world),
                fontSize = 16.sp,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.size(10.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                itemsIndexed(filterCategories) { index, item ->
                    FilterSectionItem(item, onClick)

                    if (filterCategories.size > 1 && index < filterCategories.size - 1) {
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FilterSectionPreview() {
    FilterSection(items = provideFilterItems(), onClick = {})
}