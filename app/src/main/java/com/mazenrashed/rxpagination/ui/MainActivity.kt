package com.mazenrashed.rxpagination.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mazenrashed.rxpagination.R
import com.mazenrashed.rxpagination.data.model.GithubRepository
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
                progress_bar.visibility = if (it) View.VISIBLE else View.GONE
            }.addTo(bag)

        viewModel
            .dataList
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { dataList ->
                this.dataList.clear()
                this.dataList.addAll(dataList)
                adapter.notifyDataSetChanged()
            }
            .addTo(bag)

        refresh_layout.setOnRefreshListener {
            viewModel.reloadDataList()
        }
    }
}
