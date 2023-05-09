package com.tunein.radiotime.categorydetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.common.component.Toolbar
import com.tunein.radiotime.domain.model.Category

@Composable
fun CategoryDetailsScreen() {
    val viewModel: CategoryDetailsViewModel = hiltViewModel()

    Column {
        Toolbar(title = stringResource(id = R.string.category_details)) {
            // Navigate back
        }
        val categories = emptyList<Category>()
        if (categories.isEmpty()) {
            EmptyScreen()
            return
        }

        CategoryDetailsSection(
            categories = categories,
            onClick = {}
        )
    }
}