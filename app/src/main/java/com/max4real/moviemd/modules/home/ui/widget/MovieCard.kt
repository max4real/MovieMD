package com.max4real.moviemd.modules.home.ui.widget

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.max4real.moviemd.R

@Composable
fun MovieCard(
    title: String,
    isFav: Boolean = false,
    onTapFav: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 64.dp, height = 96.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "?"
                )
            }
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Popular",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = onTapFav) {
                Icon(
                    painter = if (isFav)
                        painterResource(R.drawable.heart_fill)
                    else
                        painterResource(R.drawable.heart),
                    contentDescription = "Favorite"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun preview1() {
    Box(
        modifier = Modifier
            .clickable {}
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .size(width = 120.dp, height = 80.dp)
            .background(Color.Blue)
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieCardFavoritePreview() {
    MovieCard(title = "Inception", isFav = true, onTapFav = {})
}

@Preview(showBackground = true, heightDp = 1000)
@Composable
private fun ModifierOrderPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)
            )
        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .background(Color.Red)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)
            )
        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .padding(20.dp)
                .background(Color.Red)
                .size(50.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun preview4() {
    Box(
        modifier = Modifier
//            .padding(5.dp)
            .size(100.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(Color.Red)
    ) {}
}
