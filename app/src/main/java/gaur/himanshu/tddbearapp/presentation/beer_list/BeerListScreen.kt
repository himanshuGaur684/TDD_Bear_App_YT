package gaur.himanshu.tddbearapp.presentation.beer_list

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import gaur.himanshu.tddbearapp.data.model.BeerResponseItem
import gaur.himanshu.tddbearapp.navigation.NavigationItem

@Composable
fun BeerListScreen(navController: NavController,viewModel: BeerViewModel = hiltViewModel()) {

    val beerList = viewModel.beerList.value

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Beer List") }) }) {
        Log.d("TAG", "BeerListScreen: ${it}")
        if (beerList.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.testTag("progress"))
            }
        }
        beerList.data?.let {
            LazyColumn(modifier = Modifier.testTag("list")) {
                items(it) {
                    BeerListItem(it){
                        navController.navigate(NavigationItem.BeerDetails.route+"/$it")
                    }
                }
            }
        }
    }
}

@Composable
fun BeerListItem(beer: BeerResponseItem, onClick: (String) -> Unit) {

    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            onClick.invoke(beer.id.toString())
        }, verticalAlignment = Alignment.CenterVertically) {

        AsyncImage(
            model = beer.image_url, contentDescription = null, modifier = Modifier
                .size(80.dp)
                .clip(
                    CircleShape
                ),
            contentScale = ContentScale.Crop
        )

        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = beer.name,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6, maxLines = 1
            )

            Text(
                text = beer.description,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1, maxLines = 2
            )

        }

    }


}


















