
package com.wangfeixixi.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class VerticalCalendarView extends RecyclerView {
    protected Context mContext;
    protected CalendarAdapter mAdapter;
    private DayListener dayListenr;
    protected int mCurrentScrollState = 0;
    protected long mPreviousScrollPosition;
    protected int mPreviousScrollState = 0;
    private TypedArray typedArray;
    private OnScrollListener onScrollListener;

    public VerticalCalendarView(Context context) {
        this(context, null);
    }

    public VerticalCalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalCalendarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.VerticalCalendarView);
            setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            init(context);
        }
    }

    public void setListener(DayListener mController) {
        this.dayListenr = mController;
        setUpAdapter();
        setAdapter(mAdapter);
    }


    public void init(Context paramContext) {
        setLayoutManager(new LinearLayoutManager(paramContext));
        mContext = paramContext;
        setUpListView();

        onScrollListener = new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                final MonthView child = (MonthView) recyclerView.getChildAt(0);
                if (child == null) {
                    return;
                }

                mPreviousScrollPosition = dy;
                mPreviousScrollState = mCurrentScrollState;
            }
        };
    }


    protected void setUpAdapter() {
        if (mAdapter == null) {
            mAdapter = new CalendarAdapter(getContext(), dayListenr, typedArray);
        }
        mAdapter.notifyDataSetChanged();
    }

    protected void setUpListView() {
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(onScrollListener);
        setFadingEdgeLength(0);
    }

    protected DayListener getController() {
        return dayListenr;
    }

    protected TypedArray getTypedArray() {
        return typedArray;
    }

    public void clear() {
        mAdapter.clear();
    }
}