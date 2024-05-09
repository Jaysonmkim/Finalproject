package com.jayson.carspareparts.ui.theme.screens.Mpesa

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jayson.carspareparts.navigation.ROUTE_HOME
import com.jayson.carspareparts.navigation.ROUTE_LOGIN

@Composable
fun MpesaScreen(navController: NavController) {
    val context = LocalContext.current

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedButton(
        onClick = {
            navController.navigate(ROUTE_HOME)
            val simToolKitLaunchIntent =
                context.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { context.startActivity(it) }
        },
        colors = ButtonDefaults.buttonColors(Color.Gray),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()

    ){
        Text(text = "Pay via Mpesa",
            fontSize = 30.sp)


    }

}

@Preview
@Composable
private fun MpesaPrev() {
    MpesaScreen(rememberNavController())

}
