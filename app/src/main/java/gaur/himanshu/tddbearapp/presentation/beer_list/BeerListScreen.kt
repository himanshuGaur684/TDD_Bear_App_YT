package gaur.himanshu.tddbearapp.presentation.beer_list

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BeerListScreen(viewModel: BeerViewModel= hiltViewModel()) {

    val beerList = viewModel.beerList.value

    Scaffold(topBar = {TopAppBar(title={ Text(text = "Beer List") })}) {

        Log.d("TAG", "BeerListScreen: ${it}")

    }



}