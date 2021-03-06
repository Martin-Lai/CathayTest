package com.example.cathaytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cathaytest.databinding.GithubItemBinding
import com.squareup.picasso.Picasso

class ListAdapter(private val context: Context, private var githubList: List<GithubBean>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemBinding = GithubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val githubBean = githubList[position]
        holder.bind(githubBean)
        holder.itemBinding.root.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("login", githubBean.login)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = githubList.size

    fun setDataAndNotify(data: ArrayList<GithubBean>) {
        githubList = data
        notifyDataSetChanged()
    }


    class ListViewHolder(val itemBinding: GithubItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(githubBean: GithubBean) {
            itemBinding.tvName.text = githubBean.login
            itemBinding.tvTag.visibility = if (githubBean.site_admin) View.VISIBLE else View.GONE
            // use Picasso or Glide
            Picasso.get().load(githubBean.avatar_url).placeholder(R.drawable.ic_baseline_person_24).into(itemBinding.imgAvatar)
        }
    }

}