package gaur.himanshu.tddbearapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import gaur.himanshu.tddbearapp.presentation.beer_details.BeerDetailsScreen
import gaur.himanshu.tddbearapp.presentation.beer_list.BeerListScreen

@Composable
fun NavigationBeer(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.BeerList.route){
        composable( NavigationItem.BeerList.route){
            BeerListScreen(navController)
        }

        composable(NavigationItem.BeerDetails.route+"/{id}"){
            BeerDetailsScreen()
        }

    }

}