package ysn.com.demo.gesturedetector;

/**
 * @Author yangsanning
 * @ClassName SwipeMode
 * @Description 滑动模式
 * @Date 2020/4/9
 * @History 2020/4/9 author: description:
 */
public enum SlideMode {

    /**
     * 正常模式
     */
    SLIDE_NONE(0),

    /**
     * 垂直滑动
     */
    SLIDE_VERTICAL(1),

    /**
     * 从右往左滑动
     */
    SLIDE_RIGHT_TO_LEFT(2),

    /**
     * 从左往右滑动
     */
    SLIDE_LEFT_TO_RIGHT(3);

    public final int mode;

    SlideMode(int mode) {
        this.mode = mode;
    }

    /**
     * 是否是默认模式
     */
    public boolean isSlideNone() {
        return mode == SlideMode.SLIDE_NONE.mode;
    }

    /**
     * 是否垂直滑动
     */
    public boolean isSlideVertical() {
        return mode == SlideMode.SLIDE_VERTICAL.mode;
    }

    /**
     * 从左往右滑动
     */
    public boolean isSlideLeftToRight() {
        return mode == SlideMode.SLIDE_LEFT_TO_RIGHT.mode;
    }

    /**
     * 从右往左滑动
     */
    public boolean isSlideRightToLeft() {
        return mode == SlideMode.SLIDE_RIGHT_TO_LEFT.mode;
    }
}
