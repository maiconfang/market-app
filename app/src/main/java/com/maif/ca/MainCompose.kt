package com.maif.ca

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maif.ca.app.ui.components.appdrawer.AppDrawerContent
import com.maif.ca.app.ui.components.appdrawer.AppDrawerItemInfo
import com.maif.ca.app.ui.theme.AppDrawerExampleTheme
import com.maif.ca.intro.IntroViewModel
import com.maif.ca.intro.introGraph


@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    vm: IntroViewModel = hiltViewModel()
) {
    AppDrawerExampleTheme {
        Surface {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    AppDrawerContent(
                        drawerState = drawerState,
                        menuItems = DrawerParams.drawerButtons,
                        defaultPick = MainNavOption.HomeScreen
                    ) { onUserPickedOption ->
                        when (onUserPickedOption) {
                            MainNavOption.HomeScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.SettingsScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }

                            MainNavOption.AboutScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }

                            MainNavOption.MarketScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.LogoutScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }


                        }
                    }
                }
            ) {
                val isOnboarded = vm.isOnboarded.collectAsState()
                NavHost(
                    navController,
                    startDestination = if (isOnboarded.value) NavRoutes.MainRoute.name else NavRoutes.IntroRoute.name
                ) {
                    introGraph(navController)
                    mainGraph(drawerState)
                }
            }
        }
    }
}

enum class NavRoutes {
    IntroRoute,
    MainRoute,
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.HomeScreen,
            R.string.drawer_home,
            R.drawable.ic_home,
            R.string.drawer_home_description
        ),
        AppDrawerItemInfo(
            MainNavOption.MarketScreen,
            R.string.drawer_market,
            R.drawable.ic_market_shopping_cart,
            R.string.drawer_market_description
        ),

        AppDrawerItemInfo(
            MainNavOption.SettingsScreen,
            R.string.drawer_settings,
            R.drawable.ic_settings,
            R.string.drawer_settings_description
        ),
        AppDrawerItemInfo(
            MainNavOption.AboutScreen,
            R.string.drawer_about,
            R.drawable.ic_info,
            R.string.drawer_info_description
        ),
        AppDrawerItemInfo(
            MainNavOption.LogoutScreen,
            R.string.drawer_logout,
            R.drawable.ic_logout,
            R.string.drawer_info_description
        )
    )
}

@Preview
@Composable
fun MainActivityPreview() {
    MainCompose()
}