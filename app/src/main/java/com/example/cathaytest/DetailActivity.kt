package com.example.cathaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cathaytest.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(), DetailContract.IDetailActivity {

    private lateinit var binding: ActivityDetailBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        var binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun setUserInfo(user: GithubBeanDetail) {
        Picasso.get().load(user.avatar_url).placeholder(R.drawable.ic_baseline_person_24).into(binding.imgAvatar)
        binding.tvName.text = user.name
        binding.tvBio.text = user.bio
        binding.tvLogin.text = user.login
        binding.tvLocation.text = user.location
        binding.tvBlog.text = user.blog
        binding.tvTag.visibility = if (user.site_admin) View.VISIBLE else View.GONE
    }
}