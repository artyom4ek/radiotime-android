package com.tunein.radiotime.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R

/**
 * [Toolbar] displays a panel with a title and back button.
 */
@Composable
fun Toolbar(title: String, onBackPress: () -> Unit) {
    Row(
        modifier = Modifier.padding(top = 20.dp, end = 15.dp, start = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.clickable { onBackPress() },
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = stringResource(
                id = R.string.back_arrow
            )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
    }
}