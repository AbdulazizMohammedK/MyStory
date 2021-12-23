package com.android.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private var editTextUsername : EditText ?= null
    private var editTextPassword : EditText ?= null
    private var btnLogin : Button ?= null
    private var chkBox : CheckBox ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        connectViews()
        login()
       // checkFields()
    }
    private fun connectViews(){
        editTextPassword = findViewById(R.id.etPassWord)
        editTextUsername = findViewById(R.id.etUserName)
        btnLogin = findViewById(R.id.btnLogin)
        chkBox = findViewById(R.id.checkbox)
    }
    private fun login(){
        val arrayList:ArrayList<User> = ArrayList()
        arrayList.add(User("test@email.com","1234"))
        arrayList.add(User("account@gmail.com","123456"))
        arrayList.add(User("user@email.com","12345"))
       btnLogin?.setOnClickListener {

           val username = editTextUsername?.text.toString()
           val password = editTextPassword?.text.toString()
           val user = User(username,password)
               for (userArr in arrayList){
                   if (userArr.email == user.email && userArr.password == user.password){
                       finish()
                       val intent = Intent(this,MainActivity::class.java)
                       intent.putExtra("email",userArr.email)
                       startActivity(intent)
                       break
                   } else {
                       Toast.makeText(this,"Enter Your Data..",Toast.LENGTH_SHORT).show()
                   }
               }
           }

       }

    private fun checkFields(){
        btnLogin?.setOnClickListener {
            if (editTextUsername?.text?.isEmpty() == true){
                editTextUsername?.setError("Enter Your Email")
            }
            else  if (editTextPassword?.text?.isEmpty() == true){
                editTextPassword?.setError("Enter Your password")
            }
        }
    }
    }