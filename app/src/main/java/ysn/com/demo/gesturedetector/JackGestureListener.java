package ysn.com.demo.gesturedetector;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @Author yangsanning
 * @ClassName JackGestureListener
 * @Description 一句话概括作用
 * @Date 2020/4/8
 * @History 2020/4/8 author: description:
 */
public abstract class JackGestureListener extends GestureDetector.SimpleOnGestureListener {

    /**
     * 滑动偏移量, 大于他则取消滑动
     */
    private static final int DEVIATION = 120;

    /**
     * 最小水平滑动距离
     */
    private static final int HORIZONTAL_MIN_DISTANCE = 200;

    private SlideMode slideMode;

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
        if (slideMode.isSlideLeftToRight() || (slideMode.isSlideNone() && e1.getX() - e2.getX() > HORIZONTAL_MIN_DISTANCE)) {
            slideMode = SlideMode.SLIDE_LEFT_TO_RIGHT;
            slideLeftToRight(distanceX);
            return true;
        }

        // 从左往右滑动
        if (slideMode.isSlideRightToLeft() || (slideMode.isSlideNone() && e2.getX() - e1.getX() > HORIZONTAL_MIN_DISTANCE)) {
            slideRightToLeft(distanceX);
            return true;
        }
        return false;
    }

    abstract protected void slideLeftToRight(float distanceX);

    abstract protected void slideRightToLeft(float distanceX);
}
