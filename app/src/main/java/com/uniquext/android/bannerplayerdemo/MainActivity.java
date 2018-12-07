package com.uniquext.android.bannerplayerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.uniquext.android.banner.BannerPlayer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BannerPlayer bannerPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerPlayer = findViewById(R.id.banner);

        final List<String> data = new ArrayList<>();
        data.add("http://res.xyztree.com/category_1_1.png");
        data.add("http://res.xyztree.com/category_4_1.png");
        data.add("http://res.xyztree.com/category_5_1.png");
        data.add("http://res.xyztree.com/category_4_3.png");
        data.add("http://res.xyztree.com/category_2_1.png");


        bannerPlayer.setData(data);
        bannerPlayer.setOnItemOnClickListener(new BannerPlayer.OnItemOnClickListener() {
            @Override
            public void onItemClick(View view, int position, Object o) {
                Toast.makeText(MainActivity.this, (String)o, Toast.LENGTH_SHORT).show();
            }
        });
        bannerPlayer.setDelay(2000L);
        bannerPlayer.start();
    }
}
