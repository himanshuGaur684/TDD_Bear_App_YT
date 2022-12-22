package gaur.himanshu.tddbearapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gaur.himanshu.okhttpidlyingresourselibrary.OkHttpIdling
import gaur.himanshu.tddbearapp.data.BeerRepository
import gaur.himanshu.tddbearapp.data.network.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

val client = OkHttpClient()

val clientResource = OkHttpIdling.create("beerList", client = client)

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    // https://api.punkapi.com/v2/beers

    @Provides
    fun provideApiService(): ApiService =
        Retrofit.Builder().baseUrl("https://api.punkapi.com/").client(
            client
        ).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

    @Provides
    fun provideBeerRepository(apiService: ApiService) = BeerRepository(apiService)

}