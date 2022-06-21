package com.example.cathaytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cathaytest.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthCredential
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.IMainActivity {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val presenter = MainPresenter(this)
        binding.btnLogin.setOnClickListener {
            presenter.login()
        }
    }

    override fun loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, ListActivity::class.java))
        finish()
    }

    override fun loginFailure(exception: Exception) {
        Toast.makeText(this, "Login Failure \n message: " + exception.toString(), Toast.LENGTH_LONG).show()
    }

}