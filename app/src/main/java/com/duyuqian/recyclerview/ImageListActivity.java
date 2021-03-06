package com.duyuqian.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageListActivity extends AppCompatActivity {
    @BindView(R.id.multiple_recycler_view)
    RecyclerView multiRecyclerView;
    @BindString(R.string.title)
    String title;
    @BindString(R.string.description)
    String description;
    @BindString(R.string.header)
    String headerTitle;
    @BindString(R.string.image_src)
    String imageSrc;

    private List<Data> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        ButterKnife.bind(this);
        initDataList();
        ImageDataAdapter adapter = new ImageDataAdapter(this, dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        multiRecyclerView.setLayoutManager(layoutManager);
        multiRecyclerView.setAdapter(adapter);
    }

    private void initDataList() {
        int DATA_LIST_LENGTH = 100;
        for (int i = 0; i <= DATA_LIST_LENGTH; i++) {
            if (i == 0) {
                dataList.add(new Data(Data.TYPE_HEADER, headerTitle, null, 0, null));
            } else {
                dataList.add(new Data(Data.TYPE_ITEM, String.format(title, i), String.format(description, i), i, String.format(imageSrc, i)));
            }
        }
    }
}