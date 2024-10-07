package com.at.apuestatotal.presentation.screens.betDetail.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.bet.BetHistory
import com.at.apuestatotal.domain.useCase.bet.GetAllHistoryBetsUseCase
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

    init {
        viewModelScope.launch {
            val response = getAllHistoryBetsUseCase()
            when (response) {
                is ResponseState.Success -> {
                    betHistoryListFiltered = response.data
                    betHistoryList = response.data
                }

                else -> {
                    // Manejo de errores si es necesario
                }
            }
        }
    }

    fun filterByText() {
        val palabrasBusqueda = textFilter.split(" ").filter { it.isNotBlank() }

        betHistoryListFiltered = if (palabrasBusqueda.isEmpty()) {
            betHistoryList
        } else {
            betHistoryList.filter { bet ->
                palabrasBusqueda.all { palabra ->
                    betStatusMaperTitle(bet.status).contains(palabra, ignoreCase = true) ||
                            betTypeMaperTitle(bet.type).contains(palabra, ignoreCase = true) ||
                            bet.betDetails.any { betDetail ->
                                betDetail.betNivel.contains(palabra, ignoreCase = true) ||
                                        betDetail.betSelections.any { selection ->
                                            selection.eventName.contains(palabra, ignoreCase = true)
                                        }
                            }
                }
            }
        }
    }


}
