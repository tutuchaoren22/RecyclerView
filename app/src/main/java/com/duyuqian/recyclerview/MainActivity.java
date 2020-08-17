package com.duyuqian.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @OnClick({R.id.btn_skip_to_list_view, R.id.btn_skip_to_multiple_list_view, R.id.btn_skip_to_img_list_view})
    public void onClick(Button button) {
        switch (button.getId()) {
            case R.id.btn_skip_to_list_view:
                startActivityByClass(ListActivity.class);
                break;
            case R.id.btn_skip_to_multiple_list_view:
                startActivityByClass(MultipleListActivity.class);
                break;
            case  R.id.btn_skip_to_img_list_view:
                startActivityByClass(ImageListActivity.class);
                break;
        }
    }

    public void startActivityByClass(Class target){
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
}