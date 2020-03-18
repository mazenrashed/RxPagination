package com.mazenrashed.rxpagination.data.repository

import com.mazenrashed.github.data.network.ServiceGenerator
import com.mazenrashed.rxpagination.data.model.GithubRepository
import com.mazenrashed.rxpagination.data.network.EndPoints
import com.mazenrashed.rxpaginationlib.ListRepository
import io.reactivex.Single

class GithubRepositoryRepository : ListRepository<GithubRepository> {

    private val endPoints: EndPoints = ServiceGenerator.getRestService()

    override fun getDataList(page: Int, pageSize : Int): Single<ArrayList<GithubRepository>> {
        return endPoints.getRepositories(pageSize, page)
    }

}