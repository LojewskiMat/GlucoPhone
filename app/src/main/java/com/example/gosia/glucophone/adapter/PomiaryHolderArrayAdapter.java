package com.example.gosia.glucophone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gosia.glucophone.models.Pomiar;

import java.util.List;

/**
 * Created by usiek on 05.01.2018.
 */

public class PomiaryHolderArrayAdapter extends ArrayAdapter<Pomiar> {

    private final LayoutInflater inflater;
    private List<Pomiar> pomiarList;

    public PomiaryHolderArrayAdapter(@NonNull Context context, List<Pomiar> pomiarList) {
        super(context, android.R.layout.simple_list_item_1);
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
            rowView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);

        ViewHolder holder = (ViewHolder) rowView.getTag();
        if(holder == null) {
            holder = new ViewHolder();
            holder.text = (TextView) rowView.findViewById(android.R.id.text1);
            holder.timestamp = (TextView) rowView.findViewById(android.R.id.text2);
            rowView.setTag(holder);
        }

        holder.text.setText(String.valueOf(pomiar.getWartosc()));
        holder.timestamp.setText(pomiar.getData());

        return rowView;
    }

    static class ViewHolder {
        TextView text;
        TextView timestamp;
    }
}
