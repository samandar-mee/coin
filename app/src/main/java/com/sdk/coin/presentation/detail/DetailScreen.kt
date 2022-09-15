package com.sdk.coin.presentation.detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter
import com.sdk.coin.ui.theme.Purple40

@Composable
fun DetailScreen(
    navController: NavController,
    id: String,
    viewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getCoinByName(id)
    }
    val state by remember { viewModel.state }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 10.dp)) {
                IconButton(onClick = { navController.popBackStack()}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "", modifier = Modifier.size(35.dp), tint = Purple40)
                }
            }
            when (val res = state) {
                is DetailState.Loading -> Unit
                is DetailState.Error -> Toast.makeText(
                    LocalContext.current,
                    res.message, Toast.LENGTH_LONG
                ).show()
                is DetailState.Success -> {
                    Spacer(modifier = Modifier.height(30.dp))
                    val painter = rememberCoilPainter(request = res.detail.image)
                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = res.detail.name, fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Purple40)
                }
            }
        }
    }
}