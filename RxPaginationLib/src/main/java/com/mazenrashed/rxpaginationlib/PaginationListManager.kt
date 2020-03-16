package com.mazenrashed.rxpaginationlib

interface PaginationListManager<T> {

    fun addToList(newMembers: ArrayList<T>)

    fun reloadList()

}