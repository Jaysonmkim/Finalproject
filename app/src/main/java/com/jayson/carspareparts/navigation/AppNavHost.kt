package com.jayson.carspareparts.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jayson.carspareparts.ui.theme.screens.Mpesa.MpesaScreen
//import com.jayson.carspareparts.ui.theme.screens.Spareparts.MyCustomList
import com.jayson.carspareparts.ui.theme.screens.Spareparts.MyIndexList
import com.jayson.carspareparts.ui.theme.screens.home.HomeScreen
import com.jayson.carspareparts.ui.theme.screens.login.LoginScreen
import com.jayson.carspareparts.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController:NavHostController= rememberNavController(), startDestination:String= ROUTE_LOGIN) {

    NavHost(navController = navController, modifier=Modifier, startDestination = startDestination ){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }

        composable(ROUTE_CARHIRE){
            HomeScreen(navController)
        }

        composable(ROUTE_SPAREPARTS){
            MyIndexList(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_MPESA){
            MpesaScreen(navController)
        }

    }

}