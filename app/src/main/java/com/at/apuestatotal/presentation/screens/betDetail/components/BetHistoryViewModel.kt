package com.at.apuestatotal.presentation.screens.betDetail.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.bet.BetHistory
import com.at.apuestatotal.domain.useCase.bet.GetAllHistoryBetsUseCase
import com.at.apuestatotal.presentation.utils.CASHOUT
import com.at.apuestatotal.presentation.utils.LOST
import com.at.apuestatotal.presentation.utils.MULTIPLE
import com.at.apuestatotal.presentation.utils.OPEN
import com.at.apuestatotal.presentation.utils.SIMPLE
import com.at.apuestatotal.presentation.utils.SYSTEM
import com.at.apuestatotal.presentation.utils.WON
import com.at.apuestatotal.presentation.utils.betAllMaperTitle
import com.at.apuestatotal.presentation.utils.betStatusMaperTitle
import com.at.apuestatotal.presentation.utils.betTypeMaperTitle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BetHistoryViewModel @Inject constructor(private val getAllHistoryBetsUseCase: GetAllHistoryBetsUseCase) :
    ViewModel() {

    var betHistoryListFiltered by mutableStateOf<List<BetHistory>>(emptyList())
    private var betHistoryList by mutableStateOf<List<BetHistory>>(emptyList())

    var textFilter by mutableStateOf("")
    var isFilterShow by mutableStateOf(false)
    var updateList by mutableStateOf(false)

    val listFiltros = listOf(
        LOST,
        WON,
        OPEN,
        CASHOUT,
        SIMPLE,
        MULTIPLE,
        SYSTEM
    )
    val filtrosSeleccionados = mutableStateListOf<String>()

    init {
        viewModelScope.launch {
            val response = getAllHistoryBetsUseCase()
            when (response) {
                is ResponseState.Success -> {
                    betHistoryListFiltered = response.data
                    betHistoryList = response.data
                }

                else -> {

                }
            }
        }
    }

    fun filterByText() {
        val palabrasBusqueda = textFilter.split(" ").filter { it.isNotBlank() }

        betHistoryListFiltered = betHistoryList.filter { bet ->

            val cumpleFiltrosSeleccionados =
                filtrosSeleccionados.isEmpty() || filtrosSeleccionados.any { filtro ->
                    bet.status == filtro || bet.type == filtro
                }


            val cumpleFiltroDeTexto =
                palabrasBusqueda.isEmpty() || palabrasBusqueda.all { palabra ->
                    betAllMaperTitle(bet.status).contains(palabra, ignoreCase = true) ||
                            betAllMaperTitle(bet.type).contains(palabra, ignoreCase = true) ||
                            bet.betDetails.any { betDetail ->
                                betDetail.betNivel.contains(palabra, ignoreCase = true) ||
                                        betDetail.betSelections.any { selection ->
                                            selection.eventName.contains(palabra, ignoreCase = true)
                                        }
                            }
                }

            cumpleFiltrosSeleccionados && cumpleFiltroDeTexto
        }
        updateList = !updateList
    }


}
