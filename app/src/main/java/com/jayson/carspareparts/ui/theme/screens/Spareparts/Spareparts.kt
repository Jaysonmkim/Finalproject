package com.jayson.carspareparts.ui.theme.screens.Spareparts

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.leanback.widget.ListRow
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jayson.carspareparts.R
import com.jayson.carspareparts.navigation.ROUTE_MPESA
import com.jayson.carspareparts.navigation.ROUTE_REGISTER
import com.jayson.carspareparts.ui.theme.CarSparePartsTheme
import com.jayson.carspareparts.ui.theme.screens.Mpesa.MpesaScreen
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class CustomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarSparePartsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    MyIndexList(navController = rememberNavController())
                }
            }
        }
    }
}

data class FruitsModel (val name:String, val image :Int)
@Composable
fun ListRow(model: FruitsModel,navController:NavHostController) {
    var order by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        OutlinedTextField(value =order, onValueChange = {order=it},
            label = { Text(text = "Make an Order") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        )
        Button(onClick = {
            navController.navigate(ROUTE_MPESA)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Pay Here")
        }
    }


}
private val SparePartsList = mutableListOf<FruitsModel>().apply {
    add(FruitsModel("Engine", R.drawable.engine))
    add(FruitsModel("Wheels", R.drawable.tires))
    add(FruitsModel("Car Battery", R.drawable.battery))
    add(FruitsModel("Suspension", R.drawable.suspension))
    add(FruitsModel("Oil Filter", R.drawable.oilfilter))
    add(FruitsModel("Clutch", R.drawable.clutch))
    add(FruitsModel("Exhaust Pipe", R.drawable.exhaust))
    add(FruitsModel("Wind Shield", R.drawable.windshield))
    add(FruitsModel("Side Mirror", R.drawable.side))
}

@Composable
fun MyIndexList(navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        items(SparePartsList) { model ->
            ListRow(model = model,navController)
        }
    }
}


@Preview
@Composable
private fun Customprev() {
    MyIndexList(rememberNavController())
}
