package gaur.himanshu.tddbearapp.presentation.beer_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.tddbearapp.common.Resource
import gaur.himanshu.tddbearapp.data.BeerRepository
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(private val repository: BeerRepository) : ViewModel() {

    private val _beerList = mutableStateOf(BeerListState())
    val beerList: State<BeerListState> get() = _beerList

    init {

        _beerList.value = BeerListState(isLoading = true)
        getBeerList()
    }


    fun getBeerList() = viewModelScope.launch {
        repository.getBeerList().onEach {
            when (it) {
                is Resource.Success -> {
                    _beerList.value = BeerListState(data = it.data)
                }
                is Resource.Error -> {
                    _beerList.value = BeerListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }


}