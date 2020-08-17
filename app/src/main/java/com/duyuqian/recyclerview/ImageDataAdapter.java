package com.duyuqian.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ImageDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data> dataList;
    private Context mContext;

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView number;
        TextView description;
        ImageView image;

        public ContentViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            number = view.findViewById(R.id.number);
            description = view.findViewById(R.id.description);
            image = view.findViewById(R.id.image);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;

        public HeaderViewHolder(View view) {
            super(view);
            header = view.findViewById(R.id.header);
        }
    }

    public ImageDataAdapter(Context context, List<Data> data) {
        this.mContext=context;
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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item_and_img, parent, false);
                return new ContentViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataList.get(position).type) {
            case 0:
                return Data.TYPE_ITEM;
            case 1:
                return Data.TYPE_HEADER;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        if (data != null) {
            switch (data.type) {
                case Data.TYPE_HEADER:
                    ((HeaderViewHolder) holder).header.setText(data.getTitle());
                    break;
                case Data.TYPE_ITEM:
                    ((ContentViewHolder) holder).title.setText(data.getTitle());
                    ((ContentViewHolder) holder).number.setText(String.valueOf(data.getNumber()));
                    ((ContentViewHolder) holder).description.setText(data.getDescription());
                    Glide.with(mContext).load(data.avatar).into(((ContentViewHolder) holder).image);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
