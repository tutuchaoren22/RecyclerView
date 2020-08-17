package com.duyuqian.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindString;

public class MultiTypeDataAdapter extends RecyclerView.Adapter {
    @BindString(R.string.header)
    String header;
    private List<Data> dataList;

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView number;
        TextView description;

        public ContentViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            number = view.findViewById(R.id.number);
            description = view.findViewById(R.id.description);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;

        public HeaderViewHolder(View view) {
            super(view);
            header = view.findViewById(R.id.header);
        }
    }

    public MultiTypeDataAdapter(List<Data> data) {
        dataList = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Data.TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_header, parent, false);
                return new HeaderViewHolder(view);
            case Data.TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
                return new ContentViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        if (data != null){
            switch (data.type){
                case Data.TYPE_HEADER:
                    ((HeaderViewHolder)holder).header.setText(header);
                case Data.TYPE_ITEM:
                    ((ContentViewHolder)holder).title.setText(data.getTitle());
                    ((ContentViewHolder)holder).number.setText(String.valueOf(data.getNumber()));
                    ((ContentViewHolder)holder).description.setText(data.getDescription());
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
