package wangfeixixi.github.com.wiget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_timepicker;
    Button btn_editview;
    Button btn_calendar;
    Button btn_sweet_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btn_timepicker = (Button) findViewById(R.id.btn_timepicker);
        btn_timepicker.setOnClickListener(this);
        btn_editview = (Button) findViewById(R.id.btn_editview);
        btn_editview.setOnClickListener(this);
        btn_calendar = (Button) findViewById(R.id.btn_calendar);
        btn_calendar.setOnClickListener(this);
        btn_sweet_dialog = (Button) findViewById(R.id.btn_sweet_dialog);
        btn_sweet_dialog.setOnClickListener(this);
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
