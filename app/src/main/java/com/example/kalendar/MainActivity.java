package com.example.kalendar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button button;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        timePicker.setIs24HourView(true);
        button.setOnClickListener(v -> showResult());
    }

    private void initViews() {
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        button = findViewById(R.id.button);
        textViewResult = findViewById(R.id.textViewResult);
    }

    private String getDateText() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(),
                datePicker.getMonth(),
                datePicker.getDayOfMonth());
        SimpleDateFormat format =
                new SimpleDateFormat("dd.MM.yyyy (EEEE)", Locale.getDefault());
        return format.format(calendar.getTime());
    }

    private String getTimeText() {
        return String.format(Locale.getDefault(), "%02d:%02d",
                timePicker.getHour(),
                timePicker.getMinute());
    }

    private void showResult() {
        textViewResult.setText(getDateText() + "\n" + getTimeText());
    }
}