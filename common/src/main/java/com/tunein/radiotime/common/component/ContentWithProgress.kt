package com.tunein.radiotime.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer

@Composable
fun LoadingScreen() {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
    LazyVerticalGrid(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 15.dp)
            .shimmer(shimmerInstance),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(20) {
            Card(
                modifier = Modifier
                    .size(120.dp)
                    .shimmer(shimmerInstance),
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.LightGray)
                                .width(105.dp)
                                .height(15.dp)
                                .shimmer(shimmerInstance)
                        )
                        Spacer(Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .background(Color.LightGray)
                                .width(80.dp)
                                .height(15.dp)
                                .shimmer(shimmerInstance)
                        )
                    }
                }
            )
        }
    }
}