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
public class JackGestureListener extends GestureDetector.SimpleOnGestureListener {

    /**
     * 滑动偏移量, 大于他则取消滑动
     */
    private static final int DEVIATION = 120;

    /**
     * 最小水平滑动距离
     */
    private static final int HORIZONTAL_MIN_DISTANCE = 120;


    public JackGestureListener() {
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        // 检查y轴的运动。如果它超过SWIPE_MAX_OFF_PATH, 取消滑动
        if (Math.abs(e1.getY() - e2.getY()) > DEVIATION) {
            return false;
        }

        // 从右往左滑动
        // 滑动需要超过一定的距离 (HORIZONTAL_MIN_DISTANCE)
        if (e1.getX() - e2.getX() > HORIZONTAL_MIN_DISTANCE) {
            LogUtils.d("从右往左滑动");
            return true;
        }

        // 从左往右滑动
        // 滑动需要超过一定的距离 (HORIZONTAL_MIN_DISTANCE)
        if (e2.getX() - e1.getX() > HORIZONTAL_MIN_DISTANCE) {
            LogUtils.d("从左往右滑动");
            return true;
        }
        return false;
    }
}
