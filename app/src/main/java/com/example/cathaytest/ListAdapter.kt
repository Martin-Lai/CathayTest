package com.example.cathaytest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cathaytest.databinding.GithubItemBinding

class ListAdapter(private var githubList: List<GithubBean>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemBinding = GithubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val githubBean = githubList[position]
        holder.bind(githubBean)
    }

    override fun getItemCount(): Int = githubList.size

    fun setDataAndNotify(data: ArrayList<GithubBean>) {
        githubList = data
        notifyDataSetChanged()
    }


    class ListViewHolder(private val itemBinding: GithubItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(githubBean: GithubBean) {
            itemBinding.tvName.text = githubBean.login
        }
    }

}