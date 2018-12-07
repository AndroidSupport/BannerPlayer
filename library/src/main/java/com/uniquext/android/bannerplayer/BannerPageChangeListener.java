package com.uniquext.android.bannerplayer;

import android.support.v4.view.ViewPager;

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
 * @date 2018/12/6  21:13
 */
public class BannerPageChangeListener implements ViewPager.OnPageChangeListener {

    /**
     * 基数
     */
    private int mCardinalNumber;
    private ViewPager mViewPager;

    public BannerPageChangeListener(ViewPager viewPager, int cardinalNumber) {
        mViewPager = viewPager;
        mCardinalNumber = cardinalNumber;
    }

    public int getCardinalNumber() {
        return mCardinalNumber;
    }

    public void setCardinalNumber(int cardinalNumber) {
        this.mCardinalNumber = cardinalNumber;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        if (i < mCardinalNumber) {
            mViewPager.setCurrentItem(i + mCardinalNumber, false);
        } else if (i > mCardinalNumber * 2) {
            mViewPager.setCurrentItem(i - mCardinalNumber, false);
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
