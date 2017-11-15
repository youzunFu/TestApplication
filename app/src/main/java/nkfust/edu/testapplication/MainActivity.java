package nkfust.edu.testapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class  MainActivity extends AppCompatActivity {
String Date_Time = "bbbb";
    private Button btn3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // textView.setText("userid:jack \n pw:1234");
       // tv1.setText("userid:jack \n"+"pw:1234 \n "+Date_Time);
        btn3 = (Button) findViewById(R.id.button3);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void pick_DateTime1(View v){
                Date_Time = " ";
                final Calendar c = Calendar.getInstance();
                int years = c.get(Calendar.YEAR);
                int months = c.get(Calendar.MONTH);
                int days = c.get(Calendar.DAY_OF_MONTH);
                int hours = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        if(hour < 10){Date_Time = Date_Time + " 0" +String.valueOf(hour)+ " ";}
                        else{Date_Time = Date_Time + String.valueOf(hour)+ " ";}
                        if(minute < 10){Date_Time = Date_Time + " 0" +String.valueOf(minute)+ " ";}
                        else{Date_Time = Date_Time + String.valueOf(minute)+ " ";}

                        tv1.setText(Date_Time);
                    }
                }, hours, minute,true).show();

                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month +1 ;
                        if(year < 10){Date_Time = Date_Time + " 0" +String.valueOf(year)+ " ";}
                        else{Date_Time = Date_Time + String.valueOf(year)+ " ";}
                        if(month < 10){Date_Time = Date_Time + " 0" +String.valueOf(month)+ " ";}
                        else{Date_Time = Date_Time + String.valueOf(month)+ " ";}
                        if(day < 10){Date_Time = Date_Time + " 0" +String.valueOf(day)+ " ";}
                        else{Date_Time = Date_Time + String.valueOf(day)+ " ";}

                    }
                }, years, months, days).show();

    }

    public void viewtestClick(View v) {
        Intent intent = new Intent(MainActivity.this,viewtestActivity.class);
        startActivityForResult(intent,1);
        this.overridePendingTransition(R.anim.dock_right_enter,R.anim.dock_left_exit);
    }

    public void financeClick(View view){
        Intent intent = new Intent(MainActivity.this,FinanceActivity.class);
        startActivityForResult(intent,1);
        this.overridePendingTransition(R.anim.dock_right_enter,R.anim.dock_left_exit);
    }
    public void pageClick(View v){
        Intent intent = new Intent(MainActivity.this,pageActivity.class);
        startActivityForResult(intent,1);
        this.overridePendingTransition(R.anim.dock_right_enter,R.anim.dock_left_exit);
    }
    public void listview_practiceClick(View v){
        Intent intent = new Intent(MainActivity.this,ListviewPractice2Activity.class);
        startActivityForResult(intent,1);
    }

    public  void FragmentClick(View v ){
        Intent intent = new Intent(MainActivity.this,MainFragmentActivity.class);
        startActivityForResult(intent,1);
        this.overridePendingTransition(R.anim.dock_right_enter,R.anim.dock_left_exit);
    }

}



