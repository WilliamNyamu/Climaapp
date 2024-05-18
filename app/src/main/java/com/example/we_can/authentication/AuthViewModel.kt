package com.example.we_can.authentication

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.we_can.navigation.NavigationItem
import com.example.we_can.navigation.ROUTE_HOME
import com.example.we_can.navigation.ROUTE_LOGIN
import com.example.we_can.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

//class AuthViewModel(var navController: NavController, var context: Context){
//
//    var mAuth: FirebaseAuth
//    val progress: ProgressDialog
//
//    init {
//        mAuth= FirebaseAuth.getInstance()
//        progress= ProgressDialog(context)
//        progress.setTitle("Loading")
//        progress.setMessage("PLease Wait.....")
//    }
//    fun signup(email:String,pass:String,confpass:String){
//        progress.show()
//
//        if (email.isBlank() || pass.isBlank() ||confpass.isBlank()){
//            progress.dismiss()
//            Toast.makeText(context,"Please email and password cannot be blank", Toast.LENGTH_LONG).show()
//            return
//        }else if (pass != confpass){
//            Toast.makeText(context,"Password do not match", Toast.LENGTH_LONG).show()
//            return
//        }else{
//            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
//                if (it.isSuccessful){
//
//                    val userdata= User(email,pass,mAuth.currentUser!!.uid)
//                    val regRef= FirebaseDatabase.getInstance().getReference()
//                        .child("Users/"+mAuth.currentUser!!.uid)
//                    regRef.setValue(userdata).addOnCompleteListener {
//
//                        if (it.isSuccessful){
//                            Toast.makeText(context,"Registered Successfully", Toast.LENGTH_LONG).show()
//                            navController.navigate(NavigationItem.Home.route)
//
//
//                        }else{
//                            Toast.makeText(context,"${it.exception!!.message}", Toast.LENGTH_LONG).show()
//                            navController.navigate(ROUTE_LOGIN)
//                        }
//                    }
//                }else{
//                    navController.navigate(ROUTE_REGISTER)
//                }
//
//            } }
//
//    }
//    fun login(email: String,pass: String){
//        progress.show()
//
//        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
//            progress.dismiss()
//            if (it.isSuccessful){
//                Toast.makeText(context,"Succeffully Logged in", Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_HOME)
////                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
//            }else{
//                Toast.makeText(context,"${it.exception!!.message}", Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_LOGIN)
//            }
//        }
//
//    }
//    fun logout(){
//        mAuth.signOut()
//        navController.navigate(ROUTE_LOGIN)
//    }
//    fun isloggedin():Boolean{
//        return mAuth.currentUser !=null
//    }
//}
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(private val navController: NavController, private val context: Context) : ViewModel() {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val loading: MutableState<Boolean> = mutableStateOf(false)

    fun signUp(email: String, password: String, confirmPassword: String) {
        if (!isValidEmail(email)) {
            showToast("Invalid email format")
            return
        }

        if (!isValidPassword(password)) {
            showToast("Password must be at least 6 characters long")
            return
        }

        if (password != confirmPassword) {
            showToast("Passwords do not match")
            return
        }

        loading.value = true
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                if (task.isSuccessful) {
                    saveUserData(email, password)
                } else {
                    handleAuthError(task.exception?.message ?: "Unknown error")
                }
            }
    }

    fun logIn(email: String, password: String) {
        loading.value = true
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loading.value = false
                if (task.isSuccessful) {
                    navController.navigate(NavigationItem.Home.route)
                } else {
                    handleAuthError(task.exception?.message ?: "Unknown error")
                }
            }
    }

    fun logOut() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    private fun isValidEmail(email: String): Boolean {
        // Basic email validation
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Password should be at least 6 characters long
        return password.length >= 6
    }

    private fun saveUserData(email: String, password: String) {
        val userData = User(email, password, mAuth.currentUser!!.uid)
        val regRef = FirebaseDatabase.getInstance().getReference()
            .child("Users/${mAuth.currentUser!!.uid}")

        regRef.setValue(userData)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("Registered successfully")
                    navController.navigate(NavigationItem.Home.route)
                } else {
                    handleAuthError(task.exception?.message ?: "Unknown error")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleAuthError(errorMessage: String) {
        showToast(errorMessage)
        navController.navigate(ROUTE_LOGIN)
    }
}




