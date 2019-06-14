package com.uniquext.android.banner;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.LinkedList;

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
class BannerHandler extends Handler {

    private static final int MSG = 1;
    private static final long DELAY = 1000L;
    private volatile boolean mCancel = true;
    private long delay = DELAY;
    private WeakReference<BannerPlayer> bannerPlayerWeakReference;
    private Deque<Message> messageQueue = new LinkedList<>();

    BannerHandler(BannerPlayer bannerPlayer) {
        this.bannerPlayerWeakReference = new WeakReference<>(bannerPlayer);
    }

    boolean isCancel() {
        return mCancel;
    }

    void start() {
        mCancel = false;
        sendMessageDelayed(obtainMessage(MSG), delay);
    }

    void cancel() {
        pause();
        removeMessages(MSG);
    }

    long getDelay() {
        return delay;
    }

    void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        synchronized (this) {
            if (!mCancel && bannerPlayerWeakReference.get() != null) {
                bannerPlayerWeakReference.get().next();
                sendMessageDelayed(obtainMessage(MSG), delay);
            }
        }
    }

    void resume() {
        mCancel = false;
        sendMessageDelayed(obtainMessage(MSG), delay);
//        while (messageQueue.peek() != null) {
//            Message message = messageQueue.pop();
//            sendMessageDelayed(message, delay);
//        }
    }

    void pause() {
        mCancel = true;
    }


}