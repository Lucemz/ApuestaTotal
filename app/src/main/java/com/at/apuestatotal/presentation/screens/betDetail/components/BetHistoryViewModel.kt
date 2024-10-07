package com.at.apuestatotal.presentation.screens.betDetail.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.bet.BetHistory
import com.at.apuestatotal.domain.useCase.bet.GetAllHistoryBetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BetHistoryViewModel @Inject constructor(private val getAllHistoryBetsUseCase: GetAllHistoryBetsUseCase) :
    ViewModel() {

    var betHistoryList by mutableStateOf<List<BetHistory>>(emptyList())

    init {
        viewModelScope.launch {

            val response = getAllHistoryBetsUseCase()

            when (response) {
                is ResponseState.Success -> {
                    betHistoryList = response.data
                }

                else -> {

                }
            }

        }
    }


}