package com.at.apuestatotal.presentation.screens.mainMenu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.at.apuestatotal.domain.model.ResponseState
import com.at.apuestatotal.domain.model.banner.Banner
import com.at.apuestatotal.domain.useCase.banner.GetAllHomeCasinoBanner
import com.at.apuestatotal.domain.useCase.banner.GetAllHomeCentralBanner
import com.at.apuestatotal.domain.useCase.banner.GetAllHomeDeportivasBanner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(
    private val getAllHomeDeportivasBanner: GetAllHomeDeportivasBanner,
    private val getAllHomeCentralBanner: GetAllHomeCentralBanner,
    private val getAllHomeCasinoBanner: GetAllHomeCasinoBanner
) :
    ViewModel() {

    var banerHomeCentralIndexSelected by mutableStateOf<Banner?>(null)
    var listaBanerHomeCentral by mutableStateOf<List<Banner>>(emptyList())
    var listaBanerHomeDeportiva by mutableStateOf<List<Banner>>(emptyList())
    var listaBanerHomeCasino by mutableStateOf<List<Banner>>(emptyList())


    init {

        getHomeDeportivasBanner()
        getHomeCentralBanner()
        getHomeCasinoBanner()

    }

    fun autoChangeHomeTop() {
        var counter = 0
        viewModelScope.launch {


                while (true) {
                    counter = changeMainHomeImage(counter)
                    counter++
                    delay(5000)

                }

        }

    }

    fun changeMainHomeImage(indexNew: Int): Int {

        val newIndex: Int? = when {
            indexNew in 0..listaBanerHomeCentral.lastIndex -> indexNew
            indexNew > listaBanerHomeCentral.lastIndex -> listaBanerHomeCentral.firstOrNull()
                ?.let { 0 }

            indexNew < 0 -> listaBanerHomeCentral.lastIndex
            else -> null
        }
        banerHomeCentralIndexSelected = listaBanerHomeCentral.getOrNull(newIndex ?: 0)
        return newIndex ?: 0

    }

    fun getHomeDeportivasBanner() {
        viewModelScope.launch {
            val listoncio = getAllHomeDeportivasBanner()

            when (listoncio) {
                is ResponseState.Success -> {
                    listaBanerHomeDeportiva = listoncio.data
                }

                is ResponseState.Error -> {

                    Log.e("error", listoncio.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomeCentralBanner() {
        viewModelScope.launch {
            val listoncio = getAllHomeCentralBanner()

            when (listoncio) {
                is ResponseState.Success -> {
                    listaBanerHomeCentral = listoncio.data
                    autoChangeHomeTop()
                }

                is ResponseState.Error -> {

                    Log.e("error", listoncio.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

    fun getHomeCasinoBanner() {
        viewModelScope.launch {
            val listoncio = getAllHomeCasinoBanner()

            when (listoncio) {
                is ResponseState.Success -> {
                    listaBanerHomeCasino = listoncio.data
                    autoChangeHomeTop()
                }

                is ResponseState.Error -> {

                    Log.e("error", listoncio.errorInfo.toString())
                }

                else -> {

                }
            }
        }

    }

}