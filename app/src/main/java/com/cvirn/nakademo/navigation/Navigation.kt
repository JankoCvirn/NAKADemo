package com.cvirn.nakademo.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cvirn.nakademo.screen.home.HomeScreen
import com.cvirn.nakademo.screen.statistics.StatisticsScreen
import com.cvirn.nakademo.screen.user.UserScreen
import com.google.gson.Gson
import db.User

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation(
    padding: PaddingValues,
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = NavigationRoute.HOME_SCREEN) {
        composable(NavigationRoute.HOME_SCREEN) {
            HomeScreen(
                paddingValues = padding,
                onNavigateToCreate = { navController.navigate(NavigationRoute.CREATE_USER_SCREEN) },
                onNavigateToUpdate = { task ->
                    val taskJson = task?.let { Gson().toJson(it) }
                    navController.navigate("${NavigationRoute.UPDATE_USER_SCREEN}/$taskJson")
                },
            )
        }
        composable(NavigationRoute.CREATE_USER_SCREEN) {
            UserScreen(user = null, onNavigateBack = { navController.popBackStack() })
        }

        composable(NavigationRoute.STATISTICS_SCREEN) {
            StatisticsScreen()
        }

        composable(
            "${NavigationRoute.UPDATE_USER_SCREEN}/{${NavigationRoute.UPDATE_PARAM}}",
            arguments =
                listOf(
                    navArgument(NavigationRoute.UPDATE_PARAM) {
                        type = NavType.StringType
                    },
                ),
        ) { backStackEntry ->
            val userJson = backStackEntry.arguments?.getString(NavigationRoute.UPDATE_PARAM)
            val user =
                userJson?.let {
                    Gson().fromJson(it, User::class.java)
                }
            UserScreen(user = user, onNavigateBack = { navController.popBackStack() })
        }
    }
}

object NavigationRoute {
    const val HOME_SCREEN: String = "home"
    const val CREATE_USER_SCREEN: String = "createUser"
    const val UPDATE_USER_SCREEN: String = "updateUser"
    const val STATISTICS_SCREEN: String = "userStatistics"
    const val UPDATE_PARAM: String = "userJson"
}