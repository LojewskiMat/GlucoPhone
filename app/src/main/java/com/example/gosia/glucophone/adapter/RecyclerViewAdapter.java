package com.example.gosia.glucophone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.gosia.glucophone.R;
import com.example.gosia.glucophone.models.Pomiar;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private List<Pomiar>pomiarListList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Pomiar> pomiarListList) {
        this.pomiarListList = pomiarListList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pomiar_item, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Pomiar pomiar= pomiarListList.get(i);
        customViewHolder.wartosc.setText(String.valueOf(pomiar.getWartosc()));
        customViewHolder.dataPomiaru.setText(pomiar.getData());
    }

    @Override
    public int getItemCount() {
        return (null != pomiarListList ? pomiarListList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView wartosc;
        TextView dataPomiaru;

        CustomViewHolder(View view) {
            super(view);
            this.wartosc = (TextView) view.findViewById(R.id.wartosc_pomiaru);
            this.dataPomiaru = (TextView) view.findViewById(R.id.data_pomiaru);
        }
    }
}