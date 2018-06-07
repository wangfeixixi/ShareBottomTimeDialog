package wangfeixixi.share.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by xuany on 2018/3/27.
 */

public class DragScrollView extends ScrollView {
    private float lastY;//TouchEvent最后一次坐标(lastX,lastY)
    private boolean canScroll = true;

    public DragScrollView(Context context) {
        super(context, null);
    }

    public DragScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public DragScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    float eY;
    int offset;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        eY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = eY;
                canScroll = true;
                super.onTouchEvent(event);
                return true;
            case MotionEvent.ACTION_MOVE:
                if (!canScroll) {
                    return false;
                }
                offset = (int) (lastY - eY);
                lastY = eY;
                canScroll = !isTop() || offset > 0;
                super.onTouchEvent(event);
                return canScroll;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                canScroll = true;
                break;
        }
        return super.onTouchEvent(event);
    }

    int scrollY;
    View childView;

    private boolean isTop() {
        scrollY = getScrollY();

        childView = getChildAt(0);
        return childView != null && scrollY <= 1 && childView.getTop() >= 0;
    }
}
