package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unimayor_mvil.R;

import java.util.ArrayList;
import java.util.List;

import Clases.Notas;

public class Notas_Adaptador extends RecyclerView.Adapter<Notas_Adaptador.Holder> {
    private List<Clases.Notas> notasList;

    public void setData(List<Notas> data) {
        notasList = (ArrayList<Notas>) data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Notas_Adaptador.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notas,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Notas_Adaptador.Holder holder, int position) {
        holder.fiarDatos(notasList.get(position));
    }

    @Override
    public int getItemCount() {
        if (notasList != null) {
            return notasList.size();
        } else {
            return 0;
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView nombre,nota1, nota2, nota3, nota4, nota_def, nota_habi;
        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textView_nom_materia_notas);
            nota1 = itemView.findViewById(R.id.textView_nota1);
            nota2 = itemView.findViewById(R.id.textView_nota2);
            nota3 = itemView.findViewById(R.id.textView_nota3);
            nota_def = itemView.findViewById(R.id.textView_nota_defi);
            nota_habi = itemView.findViewById(R.id.textView_nota_habi);
        }

        public void fiarDatos(Notas notas) {
            nombre.setText(notas.getNom_materia().toString());
            nota1.setText(String.valueOf(notas.getNota_examen1()));
            nota2.setText(String.valueOf(notas.getNota_examen2()));
            nota3.setText(String.valueOf(notas.getNota_examen3()));
            nota_def.setText(String.valueOf(notas.getNota_definitiva()));
            nota_habi.setText(String.valueOf(notas.getNota_habilitacion()));
        }
    }


}
