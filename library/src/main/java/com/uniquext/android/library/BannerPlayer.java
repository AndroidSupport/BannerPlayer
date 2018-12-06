package com.uniquext.android.library;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
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
 * @date 2018/12/6  20:47
 */
public class BannerPlayer extends FrameLayout {

    private static final int MSG = 1;
    private static final int DELAY = 1000;

    private ViewPager mViewPager;
    private boolean mCancel = false;
    private List<Object> mBannerList = new ArrayList<>();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            synchronized (BannerPlayer.this) {
                if (mCancel) {
                    return;
                }
                next();
                sendMessageDelayed(obtainMessage(MSG), DELAY);
            }
        }
    };

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
        if (mBannerList.size() == 0) {
            setBackgroundResource(R.drawable.img_default_banner);
        }
    }

    public void setData(@NonNull List<? extends Object> data) {
        if (data.size() == 0) {
            return;
        }
        setBackground(null);
        for (int i = 0; i < 3; ++i) {
            mBannerList.addAll(data);
        }
        mViewPager.setAdapter(new BannerAdapter(getContext(), mBannerList));
        mViewPager.addOnPageChangeListener(new BannerPageChangeListener(mViewPager, data.size()));
    }

    public void start() {
        if (mBannerList.size() == 0) {
            return;
        }
        mCancel = false;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
    }

    private void next() {
        int position = mViewPager.getCurrentItem();
        mViewPager.setCurrentItem(position + 1, false);
    }

    public void cancel() {
        mCancel = true;
        mHandler.removeMessages(MSG);
    }

}
