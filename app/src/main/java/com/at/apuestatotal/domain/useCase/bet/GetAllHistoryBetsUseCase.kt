package com.at.apuestatotal.domain.useCase.bet

import com.at.apuestatotal.domain.model.ErrorInfo
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.bet.BetDetailHistory
import com.at.apuestatotal.domain.model.bet.BetHistory
import com.at.apuestatotal.domain.repository.BetRepository
import javax.inject.Inject
class GetAllHistoryBetsUseCase @Inject constructor(private val betRepository: BetRepository) {

    suspend operator fun invoke(): ResponseState<List<BetHistory>> {
        val betHistoryResponse = betRepository.getAllHistory()
        val betDetailHistoryResponse = betRepository.getAllHistoryDetail()

        return when {
            betHistoryResponse is ResponseState.Success && betDetailHistoryResponse is ResponseState.Success -> {
                val betHistoryList = betHistoryResponse.data
                val betDetailHistoryList = betDetailHistoryResponse.data

                // Cruza las dos listas por `game` y `BetId`
                betHistoryList.forEach { betHistory ->
                    betHistory.wager /= 100
                    betHistory.winning /=100
                    val matchingDetails = betDetailHistoryList.filter { betDetail ->
                        betDetail.betId.toString() == betHistory.game
                    }

                    // Asegúrate de convertir la lista a mutable antes de agregar nuevos elementos
                    val mutableBetDetails = betHistory.betDetails.toMutableList()
                    mutableBetDetails.addAll(matchingDetails)
                    betHistory.betDetails = mutableBetDetails
                }

                // Retornar la lista combinada de `BetHistory`
                ResponseState.Success(betHistoryList)
            }
            betHistoryResponse is ResponseState.Error -> {
                ResponseState.Error(betHistoryResponse.errorInfo)
            }
            betDetailHistoryResponse is ResponseState.Error -> {
                ResponseState.Error(betDetailHistoryResponse.errorInfo)
            }
            else -> {
                ResponseState.Error(errorInfo = ErrorInfo()) // Manejo de otros casos inesperados
            }
        }
    }
}
