package br.com.winvents.fiap.checkpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.winvents.fiap.checkpoint.model.CursosMba

class PageCursos : AppCompatActivity() {
    private lateinit var listaCursos: MutableList<CursosMba>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_cursos)

        val tvSaida: TextView = findViewById(R.id.tvSaida)

        val nmCurso: TextView = findViewById(R.id.nmCurso)
        val unCampus: TextView = findViewById(R.id.unCampus)
        val valorCurso: TextView = findViewById(R.id.valorCurso)

        val btAdicionar: TextView = findViewById(R.id.btAdicionar)

        btAdicionar.setOnClickListener {
            cadastraItem(
                nmCurso.text.toString(),
                unCampus.text.toString(),
                valorCurso.text.toString()
            )

            atualizarTela(tvSaida)
            nmCurso.text = ""
            unCampus.text = ""
            valorCurso.text = ""
        }
        listaCursos = mutableListOf()
    }

    fun atualizarTela(saida: TextView) {
        saida.text = ""
        listaCursos.forEach {
            val texto = "${saida.text} ${it.curso} - ${it.campus} - ${it.preco} \n"
            saida.text = texto
        }
    }

    fun cadastraItem(curso: String, campus: String, preco: String) {
        listaCursos.add(CursosMba(curso = curso, campus = campus, preco = preco.toDouble()))
    }
}