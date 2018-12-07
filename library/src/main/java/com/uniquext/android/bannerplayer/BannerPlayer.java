package com.uniquext.android.bannerplayer;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import static com.uniquext.android.bannerplayer.BannerHandler.MSG;

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
    private BannerAdapter mAdapter;
    private List<Object> mBannerList = new ArrayList<>();
    private BannerPageChangeListener mPageChangeListener;
    private Handler mHandler = new BannerHandler(this);

    public BannerPlayer(@NonNull Context context) {
        this(context, null);
    }

    public BannerPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View root = LayoutInflater.from(getContext()).inflate(R.layout.banner, this, true);
        this.setBackgroundResource(R.drawable.img_default_banner);
        mViewPager = root.findViewById(R.id.vp_banner);
        mAdapter = new BannerAdapter(getContext(), mBannerList);
        mPageChangeListener = new BannerPageChangeListener(mViewPager, 0);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(mPageChangeListener);
    }

    public boolean isCancel() {
        return mCancel;
    }

    public void setData(@NonNull List<? extends Object> data) {
        if (data.size() == 0) {
            return;
        }
        setBackground(null);
        mBannerList.clear();
        for (int i = 0; i < 3; ++i) {
            mBannerList.addAll(data);
        }
        mAdapter.notifyDataSetChanged();
        mPageChangeListener.setCardinalNumber(data.size());
    }

    public void start() {
        if (mBannerList.size() == 0) {
            return;
        }
        mCancel = false;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
    }

    void next() {
        int position = mViewPager.getCurrentItem();
        mViewPager.setCurrentItem(position + 1, false);
    }

    public void cancel() {
        mCancel = true;
        mHandler.removeMessages(MSG);
    }

    public void setOnItemOnClickListener(BannerPlayer.OnItemOnClickListener onItemOnClickListener) {
        mAdapter.setOnItemOnClickListener(onItemOnClickListener);
    }

    @Override
    protected void onDetachedFromWindow() {
        cancel();
        super.onDetachedFromWindow();
    }

    public interface OnItemOnClickListener {
        void onItemClick(View view, int position, Object object);
    }


}
