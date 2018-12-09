package com.uniquext.android.banner;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import static com.uniquext.android.banner.BannerHandler.MSG;

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
 * @date 2018/12/6  20:47
 */
public class BannerPlayer extends FrameLayout {

    private boolean mCancel = false;
    private ViewPager mViewPager;

    private BannerHandler mHandler = new BannerHandler(this);

    public BannerPlayer(@NonNull Context context) {
        this(context, null);
    }

    public BannerPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View root = LayoutInflater.from(getContext()).inflate(R.layout.banner, this, true);
        mViewPager = root.findViewById(R.id.vp_banner);
    }

    public void setEmptyBackground(@DrawableRes int drawable) {
        this.setBackgroundResource(drawable);
    }

    public void start() {
        mCancel = false;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
    }

    void next() {
        int position = mViewPager.getCurrentItem();
        Log.e("#####", String.valueOf(position));
        mViewPager.setCurrentItem(position + 1, false);
    }

    public void cancel() {
        mCancel = true;
        mHandler.removeMessages(MSG);
    }

    public boolean isCancel() {
        return mCancel;
    }

    public long getDelay() {
        return mHandler.getDelay();
    }

    public void setDelay(long delay) {
        mHandler.setDelay(delay);
    }

    public void setBannerAdapter(BannerAdapter bannerAdapter) {
        mViewPager.setAdapter(new BannerPagerAdapter(bannerAdapter));
        mViewPager.addOnPageChangeListener(new BannerPageChangeListener(mViewPager, bannerAdapter));
    }

    @Override
    protected void onDetachedFromWindow() {
        cancel();
        super.onDetachedFromWindow();
    }

}
