package com.uniquext.android.bannerplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uniquext.android.library.BannerPlayer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BannerPlayer bannerPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerPlayer = findViewById(R.id.banner);

        List<String> data = new ArrayList<>();
        data.add("http://res.xyztree.com/category_1_1.png");
        data.add("http://res.xyztree.com/category_4_1.png");
        data.add("http://res.xyztree.com/category_5_1.png");
        data.add("http://res.xyztree.com/category_4_3.png");
        data.add("http://res.xyztree.com/category_2_1.png");


        bannerPlayer.setData(data);
        bannerPlayer.start();
    }
}
