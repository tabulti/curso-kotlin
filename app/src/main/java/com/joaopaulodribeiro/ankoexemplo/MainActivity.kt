package com.joaopaulodribeiro.ankoexemplo

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.email
import org.jetbrains.anko.share

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_sms) {
            val intent = Intent(this, SMSActivity::class.java)
            intent.putExtra("inicio_texto", "Olá")
            startActivity(intent)
        }
        else if (id == R.id.nav_email) {
            email("seu_email@gmail.com",
                    "Tenho um trabalho Android",
                    "Olá\n\n")
        }
        else if (id == R.id.nav_compartilhar) {
            share("http://www.jovemnerd.com", "Contato")
        }
        else if (id == R.id.nav_site) {
            browse("http://www.jovemnerd.com.br")
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}