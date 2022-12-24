package gaur.himanshu.tddbearapp.navigation

sealed class NavigationItem(val route:String){

    object BeerList : NavigationItem(route = "beer_list")
    object BeerDetails : NavigationItem(route = "beer_details")

}
