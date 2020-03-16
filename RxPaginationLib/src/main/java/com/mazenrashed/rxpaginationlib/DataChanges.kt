package com.mazenrashed.rxpaginationlib


data class DataChanges<T>(
    var list: ArrayList<T>,
    var effectedItem: Int,
    var transactionType: RxPagination.TransactionTypes
)