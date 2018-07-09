package wangfeixixi.github.com.wiget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import wangfeixixi.share.popwindow.ActionItem;
import wangfeixixi.share.popwindow.TitlePopup;

public class PopWindowActivity extends AppCompatActivity {
    private TitlePopup titlePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow_activity);
        initPopWindow();
        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titlePopup.show(v);
            }
        });
    }

    private void initPopWindow() {
        // 实例化标题栏弹窗
        titlePopup = new TitlePopup(this, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        titlePopup.setItemOnClickListener(onitemClick);
        // 给标题栏弹窗添加子类
        titlePopup.addAction(new ActionItem(this, "发起群聊",
                R.drawable.pop_menu_group));
        titlePopup.addAction(new ActionItem(this, "添加朋友",
                R.drawable.pop_menu_addfriend));
        titlePopup.addAction(new ActionItem(this, "扫一扫",
                R.drawable.pop_menu_sao));
        titlePopup.addAction(new ActionItem(this, "收钱",
                R.drawable.pop_menu_abv));
    }

    private TitlePopup.OnItemOnClickListener onitemClick = new TitlePopup.OnItemOnClickListener() {

        @Override
        public void onItemClick(ActionItem item, int position) {
            // mLoadingDialog.show();
            switch (position) {
                case 0:// 发起群聊
                    Toast.makeText(getApplicationContext(), "发起群聊", Toast.LENGTH_SHORT).show();
                    break;
                case 1:// 添加朋友
                    Toast.makeText(getApplicationContext(), "添加朋友", Toast.LENGTH_SHORT).show();
                    break;
                case 2:// 扫一扫
                    Toast.makeText(getApplicationContext(), "扫一扫", Toast.LENGTH_SHORT).show();
                    break;
                case 3:// 收钱
                    Toast.makeText(getApplicationContext(), "收钱", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
}
