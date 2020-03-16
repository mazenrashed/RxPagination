package com.mazenrashed.rxpagination.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.mazenrashed.rxpagination.R
import com.mazenrashed.rxpagination.data.model.GithubRepository
import com.mazenrashed.rxpaginationlib.RxPagination
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: GithubRepositoriesViewModel by viewModels()
    private val bag = CompositeDisposable()
    private val dataList = ArrayList<GithubRepository>()
    private val adapter = MyRecyclerViewAdapter(dataList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.reachLastItemListener = {
            if (viewModel.isLastPage.value == false)
                viewModel.loadDataList()
        }

        recycler_view.adapter = adapter

        viewModel.isLoading
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                refresh_layout.isRefreshing = it
            }.addTo(bag)
//        Observable.interval(7, TimeUnit.SECONDS)
//            .subscribe({
//                if (viewModel.isLastPage.value == false)
//                    viewModel.loadDataList()
//            }, {
//                it.printStackTrace()
//            })
//           .addTo(bag)

        viewModel
            .dataList
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it.effectedItem.let {
                    Log.d(
                        "Effected item",
                        if (it == RxPagination.ALL_ITEMS_EFFECTED) "All Items" else it.toString()
                    )
                }

                Log.d(
                    "Transaction type",
                    when (it.transactionType) {
                        RxPagination.TransactionTypes.ADD -> "Add"
                        RxPagination.TransactionTypes.DELETE -> "Delete"
                        RxPagination.TransactionTypes.MODIFY -> "Modify"
                        RxPagination.TransactionTypes.REPLACE_ALL -> "Replace All"
                    }
                )

                Log.d("list", Gson().toJson(it.list.map { it.name }))

                dataList.clear()
                dataList.addAll(it.list)
                adapter.notifyDataSetChanged()
            }
            .addTo(bag)

        refresh_layout.setOnRefreshListener {
            viewModel.reloadDataList()
        }
    }
}
