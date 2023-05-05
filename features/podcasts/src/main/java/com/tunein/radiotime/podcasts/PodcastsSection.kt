package com.tunein.radiotime.podcasts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import kotlinx.coroutines.launch

import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.podcasts.tabs.PodcastTabScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PodcastsSection(podcastTabs: List<Category>, onClick: (String) -> Unit) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
        ) {
            podcastTabs.forEachIndexed { index, tab ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = { Text(text = tab.title) },
                    icon = {
                        tab.icon?.let {
                            Icon(
                                modifier = Modifier.size(26.dp),
                                painter = painterResource(id = it),
                                contentDescription = tab.title
                            )
                        }
                    },
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }
        HorizontalPager(
            pageCount = podcastTabs.size,
            state = pagerState
        ) {
            PodcastTabScreen(podcastTabs[pagerState.currentPage].items, onClick = onClick)
        }
    }
}