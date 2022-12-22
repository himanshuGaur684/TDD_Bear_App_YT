package gaur.himanshu.tddbearapp.data.network

import gaur.himanshu.tddbearapp.data.model.BeerResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET("v2/beers")
    suspend fun getBeerList():List<BeerResponseItem>

}