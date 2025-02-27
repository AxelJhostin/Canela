package com.negocio.canela.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.negocio.canela.R
import kotlinx.coroutines.delay

@Composable
fun LogoInicial(navController: NavController) {

    //Efecto para pasar de pantalla a otra pasando 3 segundos
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("PantInicial")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(
                    8, 76, 3
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logooficial),
            contentDescription = "",
            modifier = Modifier.clip(
                CircleShape
            ).size(300.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VistaLogoInicial() {
    val navController = rememberNavController()
    LogoInicial(navController)
}