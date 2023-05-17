package com.tunein.radiotime.home.filters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.GridItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersListItem(item: GridItem, onClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(0),
        modifier = Modifier.height(50.dp),
        onClick = { onClick(item.url) }) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            item.icon?.let {
                Image(
                    modifier = Modifier.padding(10.dp),
                    colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    painter = painterResource(id = it),
                    contentDescription = item.title
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = item.title,
                fontSize = 16.sp
            )
            Image(
                modifier = Modifier.padding(10.dp),
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.primary
                ),
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.right_arrow)
            )
        }
    }
}