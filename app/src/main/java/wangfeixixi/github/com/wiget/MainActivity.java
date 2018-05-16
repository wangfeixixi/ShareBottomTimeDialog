package wangfeixixi.github.com.wiget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import wangfeixixi.github.com.bottomtimedialog.BottomDialogListener;
import wangfeixixi.github.com.bottomtimedialog.BottomTimeDialog;
import wangfeixixi.github.com.bottomtimedialog.BottomTimeShowDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        findViewById(R.id.btn_timepicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
    }

    public void pop() {
        BottomTimeDialog bottomTimeDialog = new BottomTimeDialog(MainActivity.this);
        bottomTimeDialog.setOnItemClickListener(new BottomDialogListener() {
            @Override
            public void onItemClick(String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        bottomTimeDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_timepicker:
                startActivity(new Intent(this, TimePikerActivity.class));
                break;
            case R.id.btn_editview:
                startActivity(new Intent(this, EditViewActivity.class));
                break;
            case R.id.btn_calendar:
                startActivity(new Intent(this, CalendarActivity.class));
                break;
            case R.id.btn_sweet_dialog:
                startActivity(new Intent(this, SweetDialogActivity.class));


                break;
        }
    }

}
