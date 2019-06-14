package com.uniquext.android.banner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

/**
 * 　 　　   へ　　　 　／|
 * 　　    /＼7　　　 ∠＿/
 * 　     /　│　　 ／　／
 * 　    │　Z ＿,＜　／　　   /`ヽ
 * 　    │　　　 　　ヽ　    /　　〉
 * 　     Y　　　　　   `　  /　　/
 * 　    ｲ●　､　●　　⊂⊃〈　　/
 * 　    ()　 へ　　　　|　＼〈
 * 　　    >ｰ ､_　 ィ　 │ ／／      去吧！
 * 　     / へ　　 /　ﾉ＜| ＼＼        比卡丘~
 * 　     ヽ_ﾉ　　(_／　 │／／           消灭代码BUG
 * 　　    7　　　　　　　|／
 * 　　    ＞―r￣￣`ｰ―＿
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author UniqueXT
 * @version 1.0
 * @date 2018/12/9  14:35
 */
class BannerPagerAdapter extends PagerAdapter {

    private BannerAdapter bannerAdapter;

    BannerPagerAdapter(BannerAdapter adapter) {
        bannerAdapter = adapter;
        bannerAdapter.setBannerPagerAdapter(this);
    }

    @Override
    public int getCount() {
        return bannerAdapter.getCount() * 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = bannerAdapter.createItemBanner();
        if (item == null) {
            item = new AppCompatImageView(container.getContext());
            ((AppCompatImageView) item).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        container.addView(item);
        int index = position % bannerAdapter.getCount();
        bannerAdapter.instantiateItem(item, index, bannerAdapter.getBannerList().get(index));
        return item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}