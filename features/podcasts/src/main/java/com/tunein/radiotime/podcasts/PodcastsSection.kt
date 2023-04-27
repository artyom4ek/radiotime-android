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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PodcastsSection(tabs: List<Tab>) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = { Text(text = tab.title) },
                    icon = {
                        Icon(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = tab.icon),
                            contentDescription = tab.title
                        )
                    },
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }
        HorizontalPager(
            pageCount = tabs.size,
            state = pagerState
        ) {
            tabs[pagerState.currentPage].screen()
        }
    }
}

@Preview
@Composable
fun PodcastsSectionPreview() {
    PodcastsSection(tabs = providePodcastTabs())
}