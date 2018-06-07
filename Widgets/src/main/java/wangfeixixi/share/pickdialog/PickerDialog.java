package wangfeixixi.share.pickdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import java.util.List;

import wangfeixixi.share.R;

public class PickerDialog extends Dialog {
    private Button yes;//确定按钮
    private Button no;//取消按钮
    //    private TextView titleTv;//消息标题文本
//    private String titleStr;//从外界设置的title文本
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;

    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    private PikerView pv;
    private List<String> mData;

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }

    public PickerDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_picker);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(true);

//        初始化界面控件
        initView();
//        初始化界面数据
        initData();
//        初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick(selectText);
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick(selectText);
                }
            }
        });
    }

    private String selectText;

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
//
        //如果设置按钮的文字        if (titleStr != null) {
//            titleTv.setText(titleStr);
//        }
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
        pv.setOnSelectListener(new PikerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectText = text;
            }
        });
        pv.setSelected(0);
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
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
        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);

        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
//        titleTv = (TextView) findViewById(R.id.title);
        pv = (PikerView) findViewById(R.id.pv);
        pv.setData(mData);
    }

    /**
     * 从外界Activity为Dialog设置标题
     * <p>
     * //     * @param title
     */
//    public void setTitle(String title) {
//        titleStr = title;
//    }
    public void setData(List<String> data) {
        mData = data;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
}
