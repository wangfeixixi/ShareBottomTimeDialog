package wangfeixixi.github.com.wiget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_timepicker;
    Button btn_editview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btn_timepicker = (Button) findViewById(R.id.btn_timepicker);
        btn_timepicker.setOnClickListener(this);
        btn_editview = (Button) findViewById(R.id.btn_editview);
        btn_editview.setOnClickListener(this);
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
        }
    }

}
