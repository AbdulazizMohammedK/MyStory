package com.android.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var toolBar : Toolbar?=null
    private var drawer:DrawerLayout?=null
    private var tvUser : TextView?=null
    private var tvUserName : TextView?=null
    private var nav : NavigationView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val i = intent
        i.getStringExtra("email")

        val email = intent.getStringExtra("email")
        connectViews()
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        updateEmailInHeader(email!!)
        drawerClicks()
    }

    private fun connectViews(){
        toolBar = findViewById(R.id.toolBar)
        drawer = findViewById(R.id.drawer)
        tvUser=findViewById(R.id.userText)
        tvUserName = findViewById(R.id.emailText)
        nav = findViewById(R.id.nav)
    }
    private fun setupDrawer(){
        val toggleDrawer = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
        drawer?.addDrawerListener(toggleDrawer)
        toggleDrawer.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawer?.openDrawer(GravityCompat.START)
                true
            }else -> true
        }
    }

    private fun updateEmailInHeader(email:String){
        val navHeader = nav?.getHeaderView(0)
        val textEmail = navHeader?.findViewById<TextView>(R.id.emailText)
        textEmail?.text = email
    }

    private fun drawerClicks(){
        nav?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home-> {
                    drawer?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    val i = Intent(this,LoginActivity::class.java)
                    startActivity(i)
                    finish()
                    true
                }
                else -> true
            }
        }
    }
}