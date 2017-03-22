package com.jozxi.petbeat.Objetos;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jozxi.petbeat.R;

import java.util.List;

/**
 * Created by jsara on 05/03/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.NodeMCUViewHolder>{

    List<NodeMcu> nodeMCUList;

    public Adapter(List<NodeMcu> nodeMCUList){
        this.nodeMCUList = nodeMCUList;
    }

    @Override
    public NodeMCUViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_item, parent, false);

        NodeMCUViewHolder holder = new NodeMCUViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(NodeMCUViewHolder holder, int position) {
        NodeMcu nodeMcu = nodeMCUList.get(position);

        holder.textViewTitulo.setText(nodeMcu.getId());

        if (nodeMcu.isQs() == true) {
           holder.textViewEstado.setText("Activo");
           holder.textViewEstado.setTextColor(Color.GREEN);
        }
        else {
            holder.textViewEstado.setText("Inactivo");
            holder.textViewEstado.setTextColor(Color.RED);
        }



    }

    @Override
    public int getItemCount() {
        return nodeMCUList.size();
    }

    public static class NodeMCUViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitulo;
        TextView textViewEstado;


        public NodeMCUViewHolder(View itemView) {
            super(itemView);

            textViewTitulo = (TextView) itemView.findViewById(R.id.titulo);
            textViewEstado = (TextView) itemView.findViewById(R.id.estado);

        }
    }

    

}
