package gaur.himanshu.tddbearapp.presentation.beer_details

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable


@Composable
fun BeerDetailsScreen() {

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Beer Details")}) }) {
        Log.d("TAG", "BeerDetailsScreen: ${it}")
    }

}