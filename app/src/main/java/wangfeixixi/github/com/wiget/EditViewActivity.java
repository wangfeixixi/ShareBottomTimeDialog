package wangfeixixi.github.com.wiget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EditViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_timepicker:
//                startActivity(new Intent(this, TimePikerActivity.class));
//                break;
//            case R.id.btn_editview:
//                startActivity(new Intent(this, EditViewActivity.class));
//                break;
//        }
//    }

}
