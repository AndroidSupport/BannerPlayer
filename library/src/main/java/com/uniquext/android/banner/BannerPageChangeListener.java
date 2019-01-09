package com.uniquext.android.banner;

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
class BannerPageChangeListener implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private BannerAdapter mBannerAdapter;

    BannerPageChangeListener(ViewPager viewPager, BannerAdapter bannerAdapter) {
        mViewPager = viewPager;
        mBannerAdapter = bannerAdapter;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (mViewPager.getCurrentItem() < mBannerAdapter.getCount()) {
            mViewPager.setCurrentItem(i + mBannerAdapter.getCount(), false);
        } else if (mViewPager.getCurrentItem() > mBannerAdapter.getCount() * 2) {
            mViewPager.setCurrentItem(i - mBannerAdapter.getCount(), false);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
