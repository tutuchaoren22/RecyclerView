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

public class MultipleListActivity extends AppCompatActivity {
    @BindView(R.id.multiple_recycler_view)
    RecyclerView multiRecyclerView;
    @BindString(R.string.title)
    String title;
    @BindString(R.string.description)
    String description;
    @BindString(R.string.header)
    String headerTitle;
    private List<Data> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_list);
        ButterKnife.bind(this);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        initDataList(15);
        MultiTypeDataAdapter adapter = new MultiTypeDataAdapter(dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        multiRecyclerView.setLayoutManager(layoutManager);
        multiRecyclerView.setAdapter(adapter);
    }

    private void initDataList(int size) {
        for (int i = 0; i < size + 1; i++) {
            if (i == 0) {
                dataList.add(new Data(Data.TYPE_HEADER, headerTitle, null, 0, null));
            } else {
                dataList.add(new Data(Data.TYPE_ITEM, String.format(title, i), String.format(description, i), i, null));
            }
        }
    }
}