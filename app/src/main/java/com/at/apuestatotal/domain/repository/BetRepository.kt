package com.at.apuestatotal.domain.repository

import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.bet.BetDetailHistory
import com.at.apuestatotal.domain.model.bet.BetHistory

interface BetRepository {
    suspend fun getAllHistory(): ResponseState<List<BetHistory>>
    suspend fun getAllHistoryDetail(): ResponseState<List<BetDetailHistory>>
}