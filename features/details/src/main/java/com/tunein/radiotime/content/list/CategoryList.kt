package com.tunein.radiotime.content.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.AdditionalItem
import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.CategoryItems
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.ListItem

/**
 * [CategoryList] to display the list.
 */
@Composable
fun CategoryList(categoryItems: List<CategoryItems>, onClick: (String, AudioItem?) -> Unit) {
    if (categoryItems.isEmpty()) {
        EmptyScreen()
        return
    }

    LazyColumn(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categoryItems) { item ->
            if (item is ListItem) {
                /*
                 * TODO: The List Item incorrectly displays the last item with the "More Shows" item.
                 * A special check has been added to keep track of these items.
                 * In the future, this may be improved.
                 */
                if (
                    !item.subTitle.isNullOrEmpty()
                    && !item.cover.isNullOrEmpty()
                    && !item.currentTrack.isNullOrEmpty()
                ) {
                    CategoryListItem(categoryItem = item, onClick = onClick)
                } else {
                    AdditionalItem(
                        title = item.baseTitle,
                        url = item.baseUrl,
                        onClick = { onClick(it, null) }
                    )
                }
            } else if (item is GridItem) {
                AdditionalItem(
                    title = item.baseTitle,
                    url = item.baseUrl,
                    onClick = { onClick(it, null) }
                )
            }
        }
    }
}