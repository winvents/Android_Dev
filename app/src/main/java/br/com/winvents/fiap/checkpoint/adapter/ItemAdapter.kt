package br.com.winvents.fiap.checkpoint.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.winvents.fiap.checkpoint.R
import br.com.winvents.fiap.checkpoint.model.CursosMba

class ItemAdapter(val dados:List<CursosMba>, val onCursoClickListener: OnCursoClickListener):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class  ItemViewHolder(view: View, val onCursoClickListener: OnCursoClickListener)
        : RecyclerView.ViewHolder(view), View.OnClickListener{
        val tvCurso: TextView = view.findViewById(R.id.tvItemCurso)
        val tvCampus: TextView = view.findViewById(R.id.tvCampus)
        val tvPreco: TextView = view.findViewById(R.id.tvItemPreco)
        val cursoList: CardView = view.findViewById(R.id.cvItemLista)

        init{
            cursoList.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onCursoClickListener.onCursoClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista,parent,false)
        return ItemViewHolder(adapterLayout,onCursoClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val cursosMba = dados[position]
        holder.tvCampus.text = cursosMba.campus
        holder.tvCurso.text = cursosMba.curso
        holder.tvPreco.text=cursosMba.preco.toString()
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    interface OnCursoClickListener{
        fun onCursoClick(cursoClicado:Int)
    }
}