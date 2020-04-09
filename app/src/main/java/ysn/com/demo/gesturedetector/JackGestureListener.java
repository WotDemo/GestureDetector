package ysn.com.demo.gesturedetector;

import android.view.GestureDetector;
import android.view.MotionEvent;

import ysn.com.demo.gesturedetector.listener.OnSlideLeftToRightListener;
import ysn.com.demo.gesturedetector.listener.OnSlideRightToLeftListener;

/**
 * @Author yangsanning
 * @ClassName JackGestureListener
 * @Description 一句话概括作用
 * @Date 2020/4/8
 * @History 2020/4/8 author: description:
 */
public class JackGestureListener extends GestureDetector.SimpleOnGestureListener {

    /**
     * 滑动偏移量, 大于他则取消滑动
     */
    private static final int DEVIATION = 120;

    /**
     * 最小水平滑动距离
     */
    private static final int HORIZONTAL_MIN_DISTANCE = 200;

    private SlideMode slideMode;

    private OnSlideLeftToRightListener onSlideLeftToRightListener;
    private OnSlideRightToLeftListener onSlideRightToLeftListener;

    public JackGestureListener() {
    }

    @Override
    public boolean onDown(MotionEvent e) {
        slideMode = SlideMode.SLIDE_NONE;
        return super.onDown(e);
    }

    /**
     * @param e1        手指按下时的Event
     * @param e2        手指抬起时的Event
     * @param distanceX 在 X 轴上划过的距离
     * @param distanceY 在 Y 轴上划过的距离
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // 检查y轴的运动, 如果它超过SWIPE_MAX_OFF_PATH, 取消滑动
        if (slideMode.isSlideVertical() || (slideMode.isSlideNone() && Math.abs(e1.getY() - e2.getY()) > DEVIATION)) {
            slideMode = SlideMode.SLIDE_VERTICAL;
            return false;
        }

        // 从右往左滑动
        if (onSlideRightToLeftListener != null) {
            if (slideMode.isSlideRightToLeft() || (slideMode.isSlideNone() && e1.getX() - e2.getX() > HORIZONTAL_MIN_DISTANCE)) {
                slideMode = SlideMode.SLIDE_RIGHT_TO_LEFT;
                onSlideRightToLeftListener.onSlideRightToLeft(e1, e2, distanceX, distanceY);
                return true;
            }
        }

        // 从左往右滑动
        if (onSlideLeftToRightListener != null) {
            if (slideMode.isSlideLeftToRight() || (slideMode.isSlideNone() && e2.getX() - e1.getX() > HORIZONTAL_MIN_DISTANCE)) {
                slideMode = SlideMode.SLIDE_LEFT_TO_RIGHT;
                onSlideLeftToRightListener.onSlideLeftToRight(e1, e2, distanceX, distanceY);
                return true;
            }
        }
        return false;
    }

    /**
     * 设置从左向右滑动监听
     * @param onSlideLeftToRightListener 从左向右滑动监听
     */
    public JackGestureListener setOnSlideLeftToRightListener(OnSlideLeftToRightListener onSlideLeftToRightListener) {
        this.onSlideLeftToRightListener = onSlideLeftToRightListener;
        return this;
    }

    /**
     * 设置从右向左滑动时监听
     * @param onSlideRightToLeftListener 从右向左滑动时监听
     */
    public JackGestureListener setOnSlideRightToLeftListener(OnSlideRightToLeftListener onSlideRightToLeftListener) {
        this.onSlideRightToLeftListener = onSlideRightToLeftListener;
        return this;
    }
}
