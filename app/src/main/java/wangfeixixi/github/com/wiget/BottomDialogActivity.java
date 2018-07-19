package wangfeixixi.github.com.wiget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import wangfeixixi.share.bottomtimedialog.BottomCaptureDialog;
import wangfeixixi.share.bottomtimedialog.BottomDialogListener;

public class BottomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_dialog_activity);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomCaptureDialog bottomCaptureDialog = new BottomCaptureDialog(BottomDialogActivity.this);
                bottomCaptureDialog.setOnItemClickListener(new BottomDialogListener() {
                    @Override
                    public void onItemClick(String text) {
                        Toast.makeText(BottomDialogActivity.this, text, Toast.LENGTH_SHORT).show();
                    }
                });
                bottomCaptureDialog.show();
            }
        });
    }
}
