package br.com.winvents.fiap.checkpoint

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.winvents.fiap.checkpoint.model.CursosMba

class CadastroActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_cursos)

        val tvSaida: TextView = findViewById(R.id.tvSaida)

        val nomeCurso: TextView = findViewById(R.id.nmCurso)
        val campus: TextView = findViewById(R.id.unCampus)
        val valCurso: TextView = findViewById(R.id.valorCurso)

        val btAdicionar: TextView = findViewById(R.id.btAdicionar)

        btAdicionar.setOnClickListener {
            cadastraCursos(
                nomeCurso.text.toString(),
                campus.text.toString(),
                valCurso.text.toString()
            )


            nomeCurso.text = ""
            campus.text = ""
            valCurso.text = ""

            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }


    fun cadastraCursos(curso: String, campus: String, preco: String) {
        Database.listaCursos.add(
            CursosMba(
                curso = curso,
                campus = campus,
                preco = preco.toDouble()
            )
        )
    }
}