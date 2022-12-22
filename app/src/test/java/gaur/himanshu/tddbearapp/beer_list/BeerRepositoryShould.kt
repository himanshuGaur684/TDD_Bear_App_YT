package gaur.himanshu.tddbearapp.beer_list

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import gaur.himanshu.tddbearapp.MainCoroutineRule
import gaur.himanshu.tddbearapp.data.BeerRepository
import gaur.himanshu.tddbearapp.data.model.BeerResponseItem
import gaur.himanshu.tddbearapp.data.network.ApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class BeerRepositoryShould {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var repository:BeerRepository
    private lateinit var apiService: ApiService

    private val data = mock<List<BeerResponseItem>>()

    @Before
    fun setUp(){
        apiService = mock()
        repository = BeerRepository(apiService)
    }


    @Test
    fun returnSuccessWhenHeGotDataFromBackend()= runTest {
        whenever(apiService.getBeerList()).thenReturn(
            data
        )
        val result = repository.getBeerList().first()
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(data,result.data)

    }


    @Test
    fun returnErrorMessageDuringException()= runTest {
        whenever(apiService.getBeerList()).thenThrow(
            java.lang.RuntimeException("Something went wrong")
        )
        val result = repository.getBeerList().first()
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals("Something went wrong",result.message)
    }



}