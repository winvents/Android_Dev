package br.com.winvents.fiap.checkpoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.winvents.fiap.checkpoint.adapter.ItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(), ItemAdapter.OnCursoClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        Log.i("DADOS", Database.listaCursos.toString())
        val rvListaCompras: RecyclerView = findViewById(R.id.rvListaCursos)
        rvListaCompras.layoutManager = LinearLayoutManager(this)

        rvListaCompras.adapter = ItemAdapter(Database.listaCursos, this)

        val fabCadastrarCurso: FloatingActionButton = findViewById(R.id.fabCadastraCurso)
        fabCadastrarCurso.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCursoClick(cursoClicado: Int) {
        val intent  = Intent(this, VisualizarActivity::class.java)
        intent.putExtra("cursoSelecionado", Database.listaCursos[cursoClicado])
        startActivity(intent)
    }
}
