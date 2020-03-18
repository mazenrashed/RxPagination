package com.mazenrashed.rxpagination.ui

import com.jakewharton.rxrelay2.BehaviorRelay
import com.mazenrashed.rxpagination.data.model.GithubRepository
import com.mazenrashed.rxpagination.data.repository.GithubRepositoryRepository
import com.mazenrashed.rxpaginationlib.RxPagination

class GithubRepositoriesViewModel :
    RxPagination<GithubRepository>(GithubRepositoryRepository(), PAGE_SIZE, FIRST_PAGE) {

    val isLoading = BehaviorRelay.createDefault(false)

    init {
        loadDataList()
    }

    override fun onFetchDataListSubscribed() {
        isLoading.accept(true)
    }

    override fun onFetchDataListError(throwable: Throwable) {
        isLoading.accept(false)
        throwable.printStackTrace()
    }

    override fun onFetchDataListSuccess(lastLoadedList: ArrayList<GithubRepository>) {
        isLoading.accept(false)
    }

    companion object {
        const val PAGE_SIZE = 2
        const val FIRST_PAGE = 0
    }

}