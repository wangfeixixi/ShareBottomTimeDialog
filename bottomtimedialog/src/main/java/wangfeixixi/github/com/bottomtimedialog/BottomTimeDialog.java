package wangfeixixi.github.com.bottomtimedialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.TextView;

public class BottomTimeDialog extends BottomSheetDialog implements View.OnClickListener {


    public BottomTimeDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public BottomTimeDialog(@NonNull Context context, int theme) {
        super(context, theme);
        init();
    }

    protected BottomTimeDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gnetlink_bottom_duration_choose);

        findViewById(R.id.tv_always).setOnClickListener(this);
        findViewById(R.id.tv_one_month).setOnClickListener(this);
        findViewById(R.id.tv_one_week).setOnClickListener(this);
        findViewById(R.id.tv_one_day).setOnClickListener(this);
        findViewById(R.id.tv_identify).setOnClickListener(this);
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
