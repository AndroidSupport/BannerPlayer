package com.uniquext.android.banner;

import android.widget.ImageView;

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
 * @date 2018/12/9  15:04
 */
public abstract class BannerAdapter<T> {

    private List<T> mBannerList;
    private BannerPagerAdapter bannerPagerAdapter;

    public BannerAdapter(List<T> banners) {
        this.mBannerList = banners;
    }

    public List<T> getBannerList() {
        return mBannerList;
    }

    public abstract int getCount();

    public abstract void instantiateItem(ImageView view, int position, T item);

    public void notifyDataSetChanged() {
        bannerPagerAdapter.notifyDataSetChanged();
    }

    void setBannerPagerAdapter(BannerPagerAdapter bannerPagerAdapter) {
        this.bannerPagerAdapter = bannerPagerAdapter;
    }

//    void setViewPagerObserver(DataSetObserver observer) {
//        synchronized(this) {
//            this.mViewPagerObserver = observer;
//        }
//    }
//    public void notifyDataSetChanged() {
//        synchronized(this) {
//            if(this.mViewPagerObserver != null) {
//                this.mViewPagerObserver.onChanged();
//            }
//        }
//
//        this.mObservable.notifyChanged();
//    }
}
