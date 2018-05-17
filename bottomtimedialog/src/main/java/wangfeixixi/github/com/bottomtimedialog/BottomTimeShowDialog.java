package wangfeixixi.github.com.bottomtimedialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class BottomTimeShowDialog extends BottomSheetDialog implements View.OnClickListener {


    public BottomTimeShowDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public BottomTimeShowDialog(@NonNull Context context, int theme) {
        super(context, theme);
        init();
    }

    protected BottomTimeShowDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.gnetlink_bottom_duration_temporary_choose, null);

        setContentView(view);

        View parent = (View) view.getParent();
        parent.measure(0, 0);
        BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(parent);
        behavior.setPeekHeight(view.getMeasuredHeight());
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);


        findViewById(R.id.tv_quarter).setOnClickListener(this);
        findViewById(R.id.tv_half_hour).setOnClickListener(this);
        findViewById(R.id.tv_one_hour).setOnClickListener(this);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
    }

    private void init() {

        setCancelable(true);
        setCanceledOnTouchOutside(true);


    }

    private BottomDialogListener mListener;

    public void setOnItemClickListener(BottomDialogListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
        dismiss();
//        if (v.getId() == R.id.tv_always) {
//            if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
//        } else if (v.getId() == R.id.tv_one_month) {
//            if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
//        } else if (v.getId() == R.id.tv_one_week) {
//            if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
//        } else if (v.getId() == R.id.tv_one_day) {
//            if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
//        } else if (v.getId() == R.id.tv_one_hour) {
//            if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
//        }
    }
}
