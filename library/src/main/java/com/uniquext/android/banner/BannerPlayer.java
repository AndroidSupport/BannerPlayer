package com.uniquext.android.banner;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

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
        this.mViewPager = new ViewPager(context);
        this.addView(mViewPager);
    }

    public void setEmptyBackground(@DrawableRes int drawable) {
        this.setBackgroundResource(drawable);
    }

    public void start() {
        if (mHandler.isCancel()) {
            mHandler.start();
        }
    }

    void next() {
        int position = mViewPager.getCurrentItem();
        mViewPager.setCurrentItem(position + 1, true);
    }

    public void cancel() {
        if (!mHandler.isCancel()) {
            mHandler.cancel();
        }
    }

    public boolean isCancel() {
        return mHandler.isCancel();
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

    public void notifyDataSetChanged() {
        if (mViewPager.getAdapter() != null) {
            mViewPager.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        cancel();
        super.onDetachedFromWindow();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                mHandler.resume();
                break;
            default:
                mHandler.cancel();
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
