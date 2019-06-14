package com.uniquext.android.bannerplayerdemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.uniquext.android.banner.BannerAdapter;
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
        bannerPlayer.setEmptyBackground(R.drawable.img_default_banner);

        final List<String> data = new ArrayList<>();
        data.add("http://res.xyztree.com/category_1_1.png");
        data.add("http://res.xyztree.com/category_4_1.png");
        data.add("http://res.xyztree.com/category_5_1.png");
        data.add("http://res.xyztree.com/category_4_3.png");
        data.add("http://res.xyztree.com/category_2_1.png");


        BannerAdapter<String> bannerAdapter = new BannerAdapter<String>(data) {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public void instantiateItem(View view, int position, final String item) {
                Glide.with(MainActivity.this)
                        .asDrawable()
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.img_default_banner)
                                .error(R.drawable.img_default_banner)
                        )
                        .load(item)
                        .into((ImageView) view);
                view.setOnClickListener(v -> {
                    Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                });
            }
        };

        bannerPlayer.setBannerAdapter(bannerAdapter);
        bannerPlayer.setDelay(3000L);
        bannerPlayer.start();

//        data.remove("http://res.xyztree.com/category_2_1.png");
//        bannerAdapter.notifyDataSetChanged();
//        bannerPlayer
    }
}
