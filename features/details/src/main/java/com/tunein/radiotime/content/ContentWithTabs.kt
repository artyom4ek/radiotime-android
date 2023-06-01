package com.tunein.radiotime.content

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.style.TextOverflow

import kotlinx.coroutines.launch

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.content.audio.AudioList
import com.tunein.radiotime.content.grid.CategoryGrid
import com.tunein.radiotime.content.list.CategoryList
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.BaseTab
import com.tunein.radiotime.domain.model.GridTab
import com.tunein.radiotime.domain.model.ListTab

/**
 * [ContentWithTabs] screen to display tabbed data.
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ContentWithTabs(
    tabs: List<BaseTab>,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onClick: (String, AudioItem?) -> Unit,
) {
    if (tabs.isEmpty()) {
        EmptyScreen()
        return
    }

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        if (tabs.size > 1) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = index == pagerState.currentPage,
                        text = {
                            Text(
                                text = tab.baseTitle,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    )
                }
            }
        }
        HorizontalPager(
            pageCount = tabs.size,
            state = pagerState
        ) {
            // Depending on the type of data, display a specific screen.
            when (val baseTab = tabs[pagerState.currentPage]) {
                is GridTab -> {
                    CategoryGrid(
                        categoryItems = baseTab.items,
                        onClick = onClick
                    )
                }

                is ListTab -> {
                    CategoryList(
                        categoryItems = baseTab.items,
                        onClick = onClick
                    )
                }

                is AudioTab -> {
                    AudioList(
                        items = baseTab.items,
                        currentAudioItem = currentAudioItem,
                        isPlaying = isPlaying,
                        onPlayClick = onClick
                    )
                }

                else -> {
                    EmptyScreen()
                }
            }
        }
    }
}