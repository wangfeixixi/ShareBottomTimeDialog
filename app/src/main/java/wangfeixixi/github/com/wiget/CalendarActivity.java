package wangfeixixi.github.com.wiget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.wangfeixixi.calendar.VerticalCalendarView;

import com.wangfeixixi.calendar.CalendarDay;
import com.wangfeixixi.calendar.DayListener;

import wangfeixixi.github.com.wiget.util.DateUtilsWWW;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener, DayListener {

    Button btn;
    VerticalCalendarView pickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        pickerView = (VerticalCalendarView) findViewById(R.id.pickerView);
        pickerView.setListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                pickerView.clear();
                break;
        }
    }

//    @Override
//    public void onDayClick(int year, int month, int day) {
//        Log.e("aaaa 000000000", day + " / " + month + " / " + year);
////        Toast.makeText(this, day + " / " + month + " / " + year, Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    public void onDaysSelected(SelectedDays<CalendarDay> selectedDays) {
//        Log.e("aaaa  daaaaaaaaaa", selectedDays.getFirst().toString() + " --> " + selectedDays.getLast().toString());
////        Toast.makeText(this, selectedDays.getFirst().toString() + " --> " + selectedDays.getLast().toString(), Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onDayClick(CalendarDay firstDay) {
//        Log.e("outer", firstDay.toString());
    }

    @Override
    public void onDaysSelected(CalendarDay firstDay, CalendarDay lastDay) {

        Log.e("outer", firstDay.toString() + " --> " + lastDay.toString() + ": " + DateUtilsWWW.getStringByFormat(firstDay.getDate().getTime(), DateUtilsWWW.dateFormatYMD) + "-->" + DateUtilsWWW.getStringByFormat(firstDay.getDate().getTime(), DateUtilsWWW.dateFormatYMD));
//        Toast.makeText(this, firstDay.toString() + " --> " + lastDay.toString(), Toast.LENGTH_SHORT).show();
    }
}
