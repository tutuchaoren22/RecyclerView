package com.duyuqian.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Data> dataList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView number;
        TextView description;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            number = view.findViewById(R.id.number);
            description = view.findViewById(R.id.description);
        }
    }

    public DataAdapter(List<Data> data) {
        dataList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.title.setText(data.getTitle());
        holder.number.setText(String.valueOf(data.getNumber()));
        holder.description.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
