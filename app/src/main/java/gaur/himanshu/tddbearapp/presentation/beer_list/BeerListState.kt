package gaur.himanshu.tddbearapp.presentation.beer_list

import gaur.himanshu.tddbearapp.data.model.BeerResponseItem

data class BeerListState(
    val isLoading:Boolean = false,
    val data:List<BeerResponseItem>?=null,
    val error:String=""
)
