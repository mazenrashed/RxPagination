package com.mazenrashed.rxpagination.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.mazenrashed.rxpagination.R
import com.mazenrashed.rxpagination.data.model.GithubRepository
import com.mazenrashed.rxpagination.databinding.RepoItemBinding
import kotlinx.android.synthetic.main.repo_item.view.*

class MyRecyclerViewAdapter(private val gitHubRepositories: ArrayList<GithubRepository>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    var reachLastItemListener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val dataBinding = RepoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(dataBinding)
    }

    override fun getItemCount(): Int = gitHubRepositories.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(gitHubRepositories[position])
        if (position >= itemCount-1)
            reachLastItemListener?.invoke()
    }


    class MyViewHolder(private val dataBinding : RepoItemBinding) : RecyclerView.ViewHolder(dataBinding.root) {

        fun bindView(repo: GithubRepository) {
            dataBinding.repo = repo
            dataBinding.executePendingBindings()

//            view.forks.text = "${repo.forksCount}"
//            view.starts.text = "${repo.stargazersCount}"
//            view.watches.text = "${repo.watchersCount}"
//            view.repo_name.text = repo.fullName
//            view.repo_desc.text = repo.description
//            view.imageView.load(repo.owner.avatarUrl) {
//                crossfade(true)
//                transformations(CircleCropTransformation())
//            }
        }
    }
}