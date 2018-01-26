package com.joaopaulodribeiro.ankoexemplo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_sms.*
import kotlinx.android.synthetic.main.content_sms.*
import org.jetbrains.anko.sendSMS

/**
 * Created by joao.paulo.d.ribeiro on 25/01/2018.
 */
class SMSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sms)
        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        et_mensagem.text = Editable
                .Factory
                .getInstance()
                .newEditable(intent.getStringExtra("inicio_texto"))
    }

    fun enviarSms( view: View? ){
        sendSMS( "999887766", et_mensagem.text.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}