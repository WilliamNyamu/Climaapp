package com.example.we_can.screens.profile

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.storage.ktx.storage

//class ProfileViewModel : ViewModel() {
//    private val database = Firebase.database.reference
//    private val storage = Firebase.storage.reference
//    val userProfile = mutableStateOf(UserProfile("", "", "", ""))
//
//    init {
//        fetchUserProfile()
//    }
//
//    private fun fetchUserProfile() {
//        val userId = "unique_user_id" // Replace with actual user ID logic
//        database.child("users").child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val profile = snapshot.getValue(UserProfile::class.java)
//                profile?.let {
//                    userProfile.value = it
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Handle error
//            }
//        })
//    }
//
//    fun saveProfile(name: String, email: String, phone: String, imageUri: Uri?) {
//        val userId = "unique_user_id" // Replace with actual user ID logic
//        val profile = userProfile.value.copy(name = name, email = email, phone = phone)
//
//        if (imageUri != null) {
//            val fileName = UUID.randomUUID().toString()
//            val imageRef = storage.child("profile_images/$fileName")
//
//            imageRef.putFile(imageUri)
//                .addOnSuccessListener { taskSnapshot ->
//                    imageRef.downloadUrl.addOnSuccessListener { uri ->
//                        profile.profilePictureUrl = uri.toString()
//                        database.child("users").child(userId).setValue(profile)
//                    }
//                }
//        } else {
//            database.child("users").child(userId).setValue(profile)
//        }
//    }
//}


data class UserProfile(
    val name: String? = null,
    val email: String? = null,
    val phone: String? = null,
    var profilePictureUrl: String = ""
) {
    constructor() : this(null, null, null, "")
}


class ProfileViewModel : ViewModel() {
    private val database = Firebase.database.reference
    private val storage = Firebase.storage.reference
    private val _userProfile = MutableStateFlow(UserProfile("", "", "", ""))
    val userProfile: StateFlow<UserProfile> = _userProfile

    init {
        fetchUserProfile()
    }

    private fun fetchUserProfile() {
        val userId = "unique_user_id" // Replace with actual user ID logic
        database.child("users").child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val profile = snapshot.getValue(UserProfile::class.java)
                profile?.let {
                    _userProfile.value = it
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    fun saveProfile(name: String, email: String, phone: String, imageUri: Uri?, onComplete: () -> Unit) {
        val userId = "unique_user_id" // Replace with actual user ID logic
        val profile = _userProfile.value.copy(name = name, email = email, phone = phone)

        if (imageUri != null) {
            val fileName = UUID.randomUUID().toString()
            val imageRef = storage.child("profile_images/$fileName")

            imageRef.putFile(imageUri)
                .addOnSuccessListener { taskSnapshot ->
                    imageRef.downloadUrl.addOnSuccessListener { uri ->
                        profile.profilePictureUrl = uri.toString()
                        database.child("users").child(userId).setValue(profile).addOnCompleteListener {
                            onComplete()
                        }
                    }
                }
        } else {
            database.child("users").child(userId).setValue(profile).addOnCompleteListener {
                onComplete()
            }
        }
    }
}
