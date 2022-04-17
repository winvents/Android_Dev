package br.com.winvents.fiap.checkpoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun pageCursos(view: View) {
        val intent = Intent(this, ListaActivity::class.java)
        startActivity(intent)
    }
}