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
import java.util.ConcurrentModificationException;
import java.util.List;

import Clases.Horarios;

public class Horarios_Adapter extends RecyclerView.Adapter<Horarios_Adapter.Holder> {
    private ArrayList<Horarios> horariosList;
    Context context;

    public void setData(List<Horarios> data) {
        horariosList = (ArrayList<Horarios>) data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Horarios_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horario, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Horarios_Adapter.Holder holder, int position) {
        holder.fijarDatos(horariosList.get(position));
    }

    @Override
    public int getItemCount() {
        if (horariosList != null) {
            return horariosList.size();
        } else {
            return 0;
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView horario, nom_materia;
        public Holder(@NonNull View itemView) {
            super(itemView);
            horario = itemView.findViewById(R.id.textView_item_horario_horario);
            nom_materia = itemView.findViewById(R.id.textView_item_horario_materia);
        }

        public void fijarDatos(Horarios horarios) {
            horario.setText(horarios.getHorario());
            nom_materia.setText(horarios.getNom_materia());
        }
    }
}
