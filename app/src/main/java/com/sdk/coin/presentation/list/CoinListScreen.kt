package com.sdk.coin.presentation.list

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.request.ImageRequest
import com.google.accompanist.coil.rememberCoilPainter
import com.sdk.coin.domain.model.CoinDetail
import com.sdk.coin.presentation.component.Screen
import com.sdk.coin.presentation.component.SearchBar
import com.sdk.coin.ui.theme.Pink40
import com.sdk.coin.ui.theme.Pink80
import com.sdk.coin.ui.theme.Purple40

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Purple40
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            CoinList(viewModel) {
                navController.navigate(
                    route = "${Screen.DetailScreen.route}/$it"
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoinList(viewModel: CoinListViewModel, onItemClicked: (String) -> Unit) {
    val state by remember { viewModel.state }

    when (val res = state) {
        is CoinListState.Loading -> Unit
        is CoinListState.Error -> Toast.makeText(
            LocalContext.current,
            res.message,
            Toast.LENGTH_LONG
        ).show()
        is CoinListState.Success -> {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(res.coins) { coin ->
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .shadow(5.dp, RoundedCornerShape(10.dp))
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                Pink80
                            )
                            .aspectRatio(1f)
                            .clickable {
                                onItemClicked(coin.id)
                            }
                    ) {
                        Column {
                            val painterImage = rememberCoilPainter(
                                ImageRequest.Builder(LocalContext.current)
                                    .data(coin.image)
                                    .build()
                            )
                            Image(
                                painter = painterImage,
                                contentDescription = "",
                                modifier = Modifier
                                    .size(120.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = coin.name,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}