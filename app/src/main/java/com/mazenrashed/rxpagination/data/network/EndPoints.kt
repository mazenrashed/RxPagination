package com.mazenrashed.rxpagination.data.network

import com.mazenrashed.rxpagination.data.model.GithubRepository
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoints {

    @GET("/users/mazenrashed/repos")
    fun getRepositories(
        @Query("per_page") pageSize: Int,
        @Query("page") page: Int
    ): Single<ArrayList<GithubRepository>>
}