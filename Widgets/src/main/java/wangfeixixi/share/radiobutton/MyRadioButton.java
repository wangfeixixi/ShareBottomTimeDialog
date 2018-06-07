package wangfeixixi.share.radiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import wangfeixixi.share.R;


public class MyRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    private Drawable drawableBottom;
    private Drawable drawableTop;
    private Drawable drawableLeft;
    private Drawable drawableRight;
    private int mTopWidth;
    private int mTopHeight;
    private int mBottomWith;
    private int mBottomHeight;
    private int mRightWidth;
    private int mRightHeight;
    private int mLeftWith;
    private int mLeftHeight;

    public MyRadioButton(Context context) {
        super(context);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            float scale = context.getResources().getDisplayMetrics().density;
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PengRadioButton);
            int n = a.getIndexCount();
            for (int i = 0; i < n; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.PengRadioButton_peng_drawableBottom) {
                    drawableBottom = a.getDrawable(attr);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableTop) {
                    drawableTop = a.getDrawable(attr);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableLeft) {
                    drawableLeft = a.getDrawable(attr);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableRight) {
                    drawableRight = a.getDrawable(attr);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableTopWidth) {
                    mTopWidth = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableTopHeight) {
                    mTopHeight = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableBottomWidth) {
                    mBottomWith = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableBottomHeight) {
                    mBottomHeight = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableRightWidth) {
                    mRightWidth = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableRightHeight) {
                    mRightHeight = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableLeftWidth) {
                    mLeftWith = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else if (attr == R.styleable.PengRadioButton_peng_drawableLeftHeight) {
                    mLeftHeight = (int) (a.getDimension(attr, 20) * scale + 0.5f);

                } else {
                }
            }
            a.recycle();
            setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
        }


    }

    public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (left != null) {
            left.setBounds(0, 0, mLeftWith <= 0 ? left.getIntrinsicWidth() : mLeftWith, mLeftHeight <= 0 ? left.getMinimumHeight() : mLeftHeight);
        }
        if (right != null) {
            right.setBounds(0, 0, mRightWidth <= 0 ? right.getIntrinsicWidth() : mRightWidth, mRightHeight <= 0 ? right.getMinimumHeight() : mRightHeight);
        }
        if (top != null) {
            top.setBounds(0, 0, mTopWidth <= 0 ? top.getIntrinsicWidth() : mTopWidth, mTopHeight <= 0 ? top.getMinimumHeight() : mTopHeight);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mBottomWith <= 0 ? bottom.getIntrinsicWidth() : mBottomWith, mBottomHeight <= 0 ? bottom.getMinimumHeight()
                    : mBottomHeight);
        }
        setCompoundDrawables(left, top, right, bottom);
    }
}
