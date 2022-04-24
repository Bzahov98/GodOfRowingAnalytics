package com.bzahov.godofrowing.analytics.ui.screens.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bzahov.godofrowing.analytics.data.models.auth.MUser
import com.bzahov.godofrowing.analytics.data.repositories.AuthRepoImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repository: AuthRepoImpl
) : ViewModel() {

    // var loadingState = MutableStateFlow(LoadingState.IDLE)

    private val auth: FirebaseAuth = repository.getAuth()

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    @Deprecated("")
    private val _authState = MutableLiveData(AuthState.Logging)
    @Deprecated("")
    val authState: LiveData<AuthState> = _authState

    private val _authStatus = MutableLiveData(Status.IDLE)
    val authStatus: LiveData<Status> = _authStatus

    @Deprecated("")
    fun onStateChanged(newState: AuthState) {
        _authState.value = newState
    }

    fun onStatusChanged(newStatus: Status) {
        _authStatus.value = newStatus
    }


    fun signInWithEmailAndPassword(email: String, password: String, failedLogin: () -> Unit, successfulLogin: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnFailureListener { task ->
                        Log.d("FB", "FAIL: signInWithEmailAndPassword: ${task.message}")
                    }
                    .addOnCompleteListener { task ->
                        _loading.value = false
                        if (task.isSuccessful) {
                            Log.d("FB", "signInWithEmailAndPassword: Yayayay! ${task.result}")
                            //Todo: take them home
                            successfulLogin()
                        } else {
                            Log.d("FB", "signInWithEmailAndPassword: ")
                            failedLogin()
                        }
                    }

            } catch (ex: Exception) {
                Log.d("FB", "signInWithEmailAndPassword: ${ex.message}")
            }


        }


    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit
    ) {
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        //me
                        val displayName = task.result?.user?.email?.split('@')?.get(0)
                        createUser(displayName)
                        home()
                    } else {
                        Log.d("FB", "createUserWithEmailAndPassword: ${task.result.toString()}")

                    }
                    _loading.value = false


                }
        }


    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid

        val user = MUser(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            quote = "Life is great",
            profession = "Android Developer",
            id = null
        ).toMap()


        FirebaseFirestore.getInstance().collection("users")
            .add(user)
    }

}