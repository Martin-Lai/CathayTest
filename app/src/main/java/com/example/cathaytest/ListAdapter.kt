package com.example.cathaytest

import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.cathaytest.databinding.GithubItemBinding
import java.net.URI

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
        private val TAG = "ListAdapter"
        fun bind(githubBean: GithubBean) {
            itemBinding.tvName.text = githubBean.login
            Thread {
                kotlin.run {
                    val im = java.net.URL(githubBean.avatar_url).openStream()
                    val image = BitmapFactory.decodeStream(im)
                    Log.d(TAG, "bind: ")
                    itemBinding.imgAvatar.post(Runnable {
                        itemBinding.imgAvatar.setImageBitmap(image)
                    })
                }
            }.start()
        }
    }

}