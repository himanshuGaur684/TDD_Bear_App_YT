package gaur.himanshu.tddbearapp.data

import gaur.himanshu.tddbearapp.common.Resource
import gaur.himanshu.tddbearapp.data.model.BeerResponseItem
import kotlinx.coroutines.flow.Flow

class BeerRepository {
    suspend fun getBeerList(): Flow<Resource<List<BeerResponseItem>>> {
        TODO("Not yet implemented")
    }
}