package wangfeixixi.github.com.wiget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

import wangfeixixi.github.com.timepicker.picker.DateTimePicker;

public class TimePikerActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_picker_activity);
        btn = (Button) findViewById(R.id.btn_timepicker);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_timepicker:
                chooseTime(1);
                break;
        }
    }

    private Date submitStartDate;
    private Date submitEndDate;

    private void chooseTime(final int type) {
        DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);

        Date startDate = new Date();
        Date endDate = addYear(5);

        picker.setDateRangeStart(startDate.getYear() + 1900, 1, 1);
        picker.setDateRangeEnd(endDate.getYear() + 1900, 12, 31);
        picker.setSelectedItem(startDate.getYear() + 1900, startDate.getMonth() + 1, startDate.getDate(), 9, 0);
        picker.setTimeRangeStart(0, 0);
        picker.setTimeRangeEnd(23, 59);
        picker.setTopLineColor(0x99FF0000);
        picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                int yearInt = Integer.parseInt(year) - 1900;
                int monthInt = Integer.parseInt(month) - 1;
                int dayInt = Integer.parseInt(day);
                int hourInt = Integer.parseInt(hour);
                int minuteInt = Integer.parseInt(minute);
                if (type == 1) {
                    //开始时间
                    submitStartDate = new Date(yearInt, monthInt, dayInt, hourInt, minuteInt);
                    btn.setText(year + "年" + month + "月" +
                            day + "日 " +
                            standardTime(hourInt) + ":" + standardTime(minuteInt));
                } else {
                    //结束时间
                    submitEndDate = new Date(yearInt, monthInt, dayInt, hourInt, minuteInt);
                    btn.setText(year + "年" + month + "月" +
                            day + "日 " +
                            standardTime(hourInt) + ":" + standardTime(minuteInt));
                }
            }
        });
        picker.show();
    }

    public static String standardTime(int a) {
        String s = String.valueOf(a);
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }

    public static Date addYear(int n) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        //System.out.println("111111111::::"+cal.getTime());
        cal.add(Calendar.YEAR, n);//增加一个月
        return cal.getTime();
    }
}
