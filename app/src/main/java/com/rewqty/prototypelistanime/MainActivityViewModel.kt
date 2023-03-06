package com.rewqty.prototypelistanime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rewqty.prototypelistanime.model.Anime
import com.rewqty.prototypelistanime.AnimeNetwork
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val myResponseList: MutableLiveData<List<Anime>> = MutableLiveData()

    fun getAnimeTop() {
        viewModelScope.launch {
            myResponseList.value = AnimeNetwork.retrofit.getAnimeTop()
        }
    }

}