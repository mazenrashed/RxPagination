package com.mazenrashed.rxpaginationlib

import androidx.lifecycle.ViewModel
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

abstract class RxPagination<T>(
    private val repository: ListRepository<T>,
    private val pageSize: Int = 10,
    private val firstPage: Int = 0
) : ViewModel(),
    ListViewModel {

    private val bag = CompositeDisposable()

    val dataList = BehaviorRelay.createDefault(ArrayList<T>())
    var page = BehaviorRelay.createDefault(firstPage)
    var isLastPage = BehaviorRelay.createDefault(false)

    private val listManager = PaginationListManagerImpl<T>(dataList, page, pageSize, isLastPage)


    override fun loadDataList() {
        repository
            .getDataList(page.value ?: firstPage, pageSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(::onFetchDataListError)
            .doOnSuccess { onFetchDataListSuccess(it) }
            .doOnSubscribe { onFetchDataListSubscribed() }
            .subscribe({ listManager.addToList(it) }, { it.printStackTrace() })
            .addTo(bag)
    }

    override fun reloadDataList() {
        listManager.reloadList()
        loadDataList()
    }

    abstract fun onFetchDataListSubscribed()

    abstract fun onFetchDataListSuccess(lastLoadedList: ArrayList<T>)

    abstract fun onFetchDataListError(throwable: Throwable)

    companion object {
        const val ALL_ITEMS_EFFECTED = -1
    }

    enum class TransactionTypes {
        REPLACE_ALL,
        DELETE,
        MODIFY,
        ADD
    }
}