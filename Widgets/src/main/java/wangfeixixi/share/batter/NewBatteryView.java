package wangfeixixi.share.batter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import wangfeixixi.share.R;

/**
 * Created by Fei.Wang20 on 2018/7/9.
 */

public class NewBatteryView extends View {
    private int mPower = 100;
    private int orientation;
    private int width;
    private int height;
    private int mColor;

    public NewBatteryView(Context context) {
        super(context);
    }

    public NewBatteryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_dialog_duration_choose, null);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);

        view.setLayoutParams(params);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Battery);
        mColor = typedArray.getColor(R.styleable.Battery_batteryColor, 0xFFFFFFFF);
        orientation = typedArray.getInt(R.styleable.Battery_batteryOrientation, 0);
        mPower = typedArray.getInt(R.styleable.Battery_batteryPower, 100);

        /**
         * recycle() :官方的解释是：回收TypedArray，以便后面重用。在调用这个函数后，你就不能再使用这个TypedArray。
         * 在TypedArray后调用recycle主要是为了缓存。当recycle被调用后，这就说明这个对象从现在可以被重用了。
         *TypedArray 内部持有部分数组，它们缓存在Resources类中的静态字段中，这样就不用每次使用前都需要分配内存。
         */
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //对View上的內容进行测量后得到的View內容占据的宽度
        width = getMeasuredWidth();
        //对View上的內容进行测量后得到的View內容占据的高度
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //判断电池方向    horizontal: 0   vertical: 1
        if (orientation == 0) {
            drawHorizontalBattery(canvas);
        } else {
            drawVerticalBattery(canvas);
        }
    }

    private void drawVerticalBattery(Canvas canvas) {

    }

    private void drawHorizontalBattery(Canvas canvas) {

    }
}
