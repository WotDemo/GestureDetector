package ysn.com.demo.gesturedetector.listener;

import android.view.MotionEvent;

/**
 * @Author yangsanning
 * @ClassName OnSlideRightToLeftListener
 * @Description 从右向左滑动时监听
 * @Date 2020/4/9
 * @History 2020/4/9 author: description:
 */
public interface OnSlideRightToLeftListener {

    /**
     * 从右向左滑动时回调
     *
     * @param e1        手指按下时的Event
     * @param e2        手指抬起时的Event
     * @param distanceX 在 X 轴上划过的距离
     * @param distanceY 在 Y 轴上划过的距离
     */
    void onSlideRightToLeft(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);
}
