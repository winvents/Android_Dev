package br.com.winvents.fiap.checkpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.winvents.fiap.checkpoint.model.CursosMba


class VisualizarActivity : AppCompatActivity() {

    private lateinit var cursoSelecionado: CursosMba

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        cursoSelecionado = intent.getSerializableExtra("CursoSelecionado") as CursosMba

        val tvNome: TextView = findViewById(R.id.tvCurso)
        val tvMarca: TextView = findViewById(R.id.tvUnidade)
        val tvPreco: TextView = findViewById(R.id.tvValCurso)

        tvNome.text = cursoSelecionado.curso
        tvMarca.text = cursoSelecionado.campus
        tvPreco.text = cursoSelecionado.preco.toString()

    }
}
