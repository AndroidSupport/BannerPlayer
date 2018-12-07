package com.uniquext.android.banner;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

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
 * @date 2018/12/7  10:59
 */
public class BannerHandler extends Handler {

    static final int MSG = 1;
    private static final long DELAY = 1000L;
    private long delay = DELAY;
    private WeakReference<BannerPlayer> bannerPlayerWeakReference;

    BannerHandler(BannerPlayer bannerPlayer) {
        this.bannerPlayerWeakReference = new WeakReference<>(bannerPlayer);
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        synchronized (bannerPlayerWeakReference.get()) {
            if (bannerPlayerWeakReference.get().isCancel()) {
                return;
            }
            bannerPlayerWeakReference.get().next();
            sendMessageDelayed(obtainMessage(MSG), delay);
        }
    }

}