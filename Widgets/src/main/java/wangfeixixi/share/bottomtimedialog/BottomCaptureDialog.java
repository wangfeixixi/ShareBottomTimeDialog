package wangfeixixi.share.bottomtimedialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import wangfeixixi.share.R;

public class BottomCaptureDialog extends BottomSheetDialog implements View.OnClickListener {


    public BottomCaptureDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public BottomCaptureDialog(@NonNull Context context, int theme) {
        super(context, theme);
        init();
    }

    protected BottomCaptureDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_dialog_capture, null);

        setContentView(view);

        View parent = (View) view.getParent();
        parent.measure(0, 0);
        BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(parent);
        behavior.setPeekHeight(view.getMeasuredHeight());
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);


        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams wlp = window.getAttributes();
        Display d = window.getWindowManager().getDefaultDisplay();//获取屏幕宽
//        wlp.width = (int) (d.getWidth() * 0.9);//宽度按屏幕大小的百分比设置
        wlp.width = d.getWidth();//宽度按屏幕大小的百分比设置
//        wlp.gravity = mParams.mGravity;
//        if (wlp.gravity == Gravity.BOTTOM)
//            wlp.y = 20; //如果是底部显示，则距离底部的距离是20
//        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);


//        View viewById = getWindow().findViewById(R.id.design_bottom_sheet);
//        viewById.setBackgroundResource(android.R.color.transparent);
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        viewById.setLayoutParams(layoutParams);


//        getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);

        findViewById(R.id.tv_camera).setOnClickListener(this);
        findViewById(R.id.tv_capture).setOnClickListener(this);
        findViewById(R.id.tv_cancel_capture).setOnClickListener(this);
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
        if (v.getId() == R.id.tv_camera || v.getId() == R.id.tv_capture || v.getId() == R.id.tv_cancel_capture) {
            if (mListener != null) mListener.onItemClick(((TextView) v).getText().toString());
        }
        dismiss();
    }
}
