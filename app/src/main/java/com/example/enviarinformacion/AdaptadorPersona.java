package com.example.enviarinformacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaviewHolder> implements View.OnClickListener{
    private List<Persona> lp;
    private Context context;
    private View.OnClickListener eventoholderclick;

    public AdaptadorPersona(List<Persona> lp, Context context) {
        this.lp = lp;
        this.context = context;
    }

    @NonNull
    @Override
    public AdaptadorPersona.PersonaviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view, viewGroup,false);
        v.setOnClickListener(this);
        return new PersonaviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.PersonaviewHolder personaviewHolder, final int i) {
        personaviewHolder.txtid.setText(lp.get(i).getId().toString());
        personaviewHolder.txtNombre.setText(lp.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return lp.size();
    }

    @Override
    public void onClick(View v) {
        if (eventoholderclick != null){
            eventoholderclick.onClick(v);
        }
    }

    public class PersonaviewHolder extends RecyclerView.ViewHolder {
        TextView txtid, txtNombre;
        public PersonaviewHolder(@NonNull View itemView) {
            super(itemView);
            txtid =itemView.findViewById(R.id.txtid);
            txtNombre = itemView.findViewById(R.id.txtNombre);
        }
    }
}
