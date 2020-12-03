package com.chiului.paging3sample

import androidx.paging.PagingSource

/**
 * PagingSource$
 * @author    神经大条蕾弟
 * @date      2020/09/15 10:54
 */
class MainPagingSource (
    val service : UserService,
    val query : String
): PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = service.getPagingUser(nextPageNumber)
            return LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = response.nextPageNumber
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}