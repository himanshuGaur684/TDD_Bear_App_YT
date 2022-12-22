package gaur.himanshu.tddbearapp.beer_list

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import gaur.himanshu.tddbearapp.MainCoroutineRule
import gaur.himanshu.tddbearapp.common.Resource
import gaur.himanshu.tddbearapp.data.BeerRepository
import gaur.himanshu.tddbearapp.data.model.BeerResponseItem
import gaur.himanshu.tddbearapp.presentation.beer_list.BeerViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BeerViewModelShould {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val repo: BeerRepository = mock()
    private lateinit var viewModel: BeerViewModel

    private val data: List<BeerResponseItem> = mock()

    @Before
    fun setup() {
        viewModel = BeerViewModel(repo)
    }

    @After
    fun tear() {

    }

    @Test
    fun showALoaderInitially() = runTest {
        Assert.assertEquals(true, viewModel.beerList.value.isLoading)
    }

    @Test
    fun validateSuccessStateDataIsStoredOnBeerList() = runTest {
        whenever(repo.getBeerList()).thenReturn(
            flow {
                emit(Resource.Success(data))
            }
        )
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(data, viewModel.beerList.value.data)
    }

    @Test
    fun validateErrorStateWhenWeReceiveErrorFromRepository() = runTest {
        whenever(repo.getBeerList()).thenReturn(
            flow {
                emit(Resource.Error("Something went wrong"))
            }
        )
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals("Something went wrong", viewModel.beerList.value.error)
    }

}