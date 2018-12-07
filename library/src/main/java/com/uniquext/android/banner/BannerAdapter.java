package com.uniquext.android.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

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
 * @date 2018/12/6  21:05
 */
public class BannerAdapter extends PagerAdapter {

    @DrawableRes
    private int mErrorResource = R.drawable.img_default_banner;
    @DrawableRes
    private int mPreviewResource = R.drawable.img_default_banner;

    private List<? extends Object> mBannerList;
    private RequestBuilder<Drawable> requestBuilder;
    private BannerPlayer.OnItemOnClickListener mOnItemOnClickListener;

    @SuppressLint("CheckResult")
    public BannerAdapter(Context context, List<? extends Object> imageList) {
        mBannerList = imageList;
        RequestOptions options = new RequestOptions();
        options.placeholder(mPreviewResource).error(mErrorResource);
        requestBuilder = Glide.with(context).asDrawable().apply(options);
    }

    @Override
    public int getCount() {
        return mBannerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = View.inflate(container.getContext(), R.layout.item_image_pager, null);
        view.setTag(position);
        container.addView(view);
        requestBuilder.load(mBannerList.get(position)).into((ImageView) view.findViewById(R.id.iv_image));
        view.setOnClickListener(v -> {
            if (mOnItemOnClickListener != null) {
                int index = (int) v.getTag();
                mOnItemOnClickListener.onItemClick(v, index, mBannerList.get(index));
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setOnItemOnClickListener(BannerPlayer.OnItemOnClickListener onItemOnClickListener) {
        this.mOnItemOnClickListener = onItemOnClickListener;
    }
}
