package com.mazenrashed.rxpaginationlib

import com.jakewharton.rxrelay2.BehaviorRelay
import com.mazenrashed.rxpaginationlib.RxPagination.Companion.ALL_ITEMS_EFFECTED

class PaginationListManagerImpl<T>(
    private val dataChanges: BehaviorRelay<DataChanges<T>>,
    private var page: BehaviorRelay<Int>,
    private val pageSize : Int,
    private var isLastPage: BehaviorRelay<Boolean>
) :
    PaginationListManager<T> {

    override fun addToList(newMembers: ArrayList<T>) {
        if (isLastPage.value == true) return
        dataChanges.accept(
            dataChanges.value.apply {
                if (page.value == 0)
                    this?.list?.clear()
                if (newMembers.isEmpty()) {
                    isLastPage.accept(true)
                    return@apply
                }

                this?.list?.addAll(newMembers.apply {
                    if (this.size < pageSize)
                        isLastPage.accept(true)
                })
            } ?: DataChanges(
                ArrayList(),
                ALL_ITEMS_EFFECTED,
                RxPagination.TransactionTypes.REPLACE_ALL
            )
        )
        page.accept(page.value?.plus(1) ?: 0)
    }

    override fun reloadList() {
        page.accept(0)
        isLastPage.accept(false)
    }


}