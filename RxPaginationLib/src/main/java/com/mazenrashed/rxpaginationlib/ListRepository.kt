package com.mazenrashed.rxpaginationlib

import io.reactivex.Single

interface ListRepository<T> {

    fun getDataList(page: Int, pageSize : Int): Single<ArrayList<T>>

}