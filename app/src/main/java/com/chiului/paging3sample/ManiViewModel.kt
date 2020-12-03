package com.chiului.paging3sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

/**
 * MainViewModel$
 * @author    神经大条蕾弟
 * @date      2020/09/15 12:20
 */
class ManiViewModel : ViewModel() {

    private var currentSearchResult: Flow<PagingData<User>>? = null

    fun getMainPagingData(): Flow<PagingData<User>> {
        val newResult: Flow<PagingData<User>> = Pager(
            // Configure how data is loaded by passing additional properties to
            // PagingConfig, such as prefetchDistance.
            PagingConfig(pageSize = 20)
        ) {
            MainPagingSource(UserService(), "")
        }.flow
            .cachedIn(viewModelScope)

        currentSearchResult = newResult
        return newResult
    }

}