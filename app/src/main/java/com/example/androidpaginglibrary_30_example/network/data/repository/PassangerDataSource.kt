package com.example.androidpaginglibrary_30_example.network.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.androidpaginglibrary_30_example.network.api.PassangerApi
import com.example.androidpaginglibrary_30_example.network.model.Passanger
import java.lang.Exception

class PassangerDataSource (
    private val api: PassangerApi
) : PagingSource<Int, Passanger>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Passanger> {
        return try {
            val nextPageNumber = params.key?:0
            val response = api.getPessagngersData(nextPageNumber)
            Log.e("laod: success :", response.data.toString())

            LoadResult.Page(
                data = response.data,
                prevKey = if(nextPageNumber > 0) nextPageNumber -1 else null,
                nextKey = if(nextPageNumber < response.totalPages) nextPageNumber + 1 else null

            )
        } catch (e: Exception) {
            Log.e("load : error :", e.message.toString())
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Passanger>): Int? {
        TODO("Not yet implemented")
    }
}