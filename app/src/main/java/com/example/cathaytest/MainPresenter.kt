package com.example.cathaytest

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthCredential
import com.google.firebase.auth.OAuthProvider

class MainPresenter(val view: MainContract.IMainActivity) : MainContract.IMainPresenter {
    override fun login() {
        FirebaseAuth.getInstance().startActivityForSignInWithProvider(
            view as Activity,
            OAuthProvider.newBuilder("github.com").build()
        ).addOnSuccessListener { result ->
            GlobalVariable.accessToken = (result.credential as OAuthCredential).accessToken!!
            view.loginSuccess()
        }.addOnFailureListener { exception -> view.loginFailure(exception) }
    }
}