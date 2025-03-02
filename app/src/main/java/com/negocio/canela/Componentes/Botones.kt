package com.negocio.canela.Componentes

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.negocio.canela.R

@Composable
fun BotonBasico(texto: String, tamanio: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(6, 55, 23),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp), // Esquinas redondeadas
        border = BorderStroke(2.dp, color = Color.White),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp, // Sombra cuando no está presionado
            pressedElevation = 2.dp  // Sombra reducida al presionar
        )
    ) {
        Text(
            text = texto,
            fontSize = tamanio.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun EspacioV(i: Int) {
    Spacer(modifier = Modifier.height(i.dp))
}

@Composable
fun EspacioH(i: Int) {
    Spacer(modifier = Modifier.width(i.dp))
}

@Preview
@Composable
fun RedesSocialesCuadro() {
    Row {
        Image(
            painter = painterResource(R.drawable.instagramlogo),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
        EspacioH(2)
        Text("enesemec.ec", fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun RedesSocialesCuadro(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick() }//para que sea clickable todo el row
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.instagramlogo),
            contentDescription = "",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Fit //para que no se distorsione
        )
        EspacioH(4)
        Text("enesemec.ec", fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun RedesSocialesCuadro(urlInstagram: String) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlInstagram))
                context.startActivity(intent)
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.instagramlogo),
            contentDescription = "Instagram",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "enesemec.ec",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}