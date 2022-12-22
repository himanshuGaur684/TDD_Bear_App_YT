package gaur.himanshu.tddbearapp.data

import gaur.himanshu.tddbearapp.common.Resource
import gaur.himanshu.tddbearapp.data.model.BeerResponseItem
import gaur.himanshu.tddbearapp.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class BeerRepository(private val apiService: ApiService) {
    suspend fun getBeerList(): Flow<Resource<List<BeerResponseItem>>> =
        flow<Resource<List<BeerResponseItem>>> {
            emit(Resource.Success(data = apiService.getBeerList()))
        }.catch {
            emit(Resource.Error(message = it.message.toString()))
        }
}