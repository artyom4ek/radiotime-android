package com.tunein.radiotime.categorydetails

import kotlinx.coroutines.launch

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.Category

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryDetailsSection(categories: List<Category>, onClick: (String) -> Unit) {
    if (categories.isEmpty()) {
        EmptyScreen()
        return
    }

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        ScrollableTabRow(
            modifier = Modifier.fillMaxWidth(),
            edgePadding = 0.dp,
            selectedTabIndex = pagerState.currentPage
        ) {
            categories.forEachIndexed { index, tab ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = {
                        Text(
                            text = tab.title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalPager(
            pageCount = categories.size,
            state = pagerState
        ) {
            TabScreen(categories[pagerState.currentPage], onClick = onClick)
        }
    }
}