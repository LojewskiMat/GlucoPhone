package com.example.gosia.glucophone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gosia.glucophone.R;
import com.example.gosia.glucophone.models.Pomiar;

import java.util.List;

import butterknife.BindView;

/**
 * Created by usiek on 05.01.2018.
 */

public class PomiaryHolderArrayAdapter extends ArrayAdapter<Pomiar> {

    private final LayoutInflater inflater;
    private List<Pomiar> pomiarList;

    public PomiaryHolderArrayAdapter(@NonNull Context context, List<Pomiar> pomiarList) {
        super(context, R.layout.pomiar_item);
        this.pomiarList = pomiarList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pomiarList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pomiar pomiar = pomiarList.get(position);
        View rowView = convertView;
        if(rowView == null)
            rowView = inflater.inflate(R.layout.pomiar_item, parent, false);

        ViewHolder holder = (ViewHolder) rowView.getTag();
        if(holder == null) {
            holder = new ViewHolder();
            holder.text = (TextView) rowView.findViewById(R.id.wartosc_pomiaru);
            holder.timestamp = (TextView) rowView.findViewById(R.id.data_pomiaru);
            rowView.setTag(holder);
        }

        holder.text.setText(String.valueOf(pomiar.getWartosc()));
        holder.timestamp.setText(pomiar.getData());

        return rowView;
    }

    static class ViewHolder {

//        @BindView(R.id.wartosc_pomiaru)
        TextView text;

//        @BindView(R.id.data_pomiaru)
        TextView timestamp;
    }
}
