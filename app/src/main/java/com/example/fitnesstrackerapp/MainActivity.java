package com.example.fitnesstrackerapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor stepSensor;
    private boolean isSensorPresent = false;
    private int stepCount = 0;

    private TextView stepText, distanceText, calorieText;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepText = findViewById(R.id.stepCount);
        distanceText = findViewById(R.id.distance);
        calorieText = findViewById(R.id.calories);
        pieChart = findViewById(R.id.pieChart);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isSensorPresent = true;
        } else {
            stepText.setText("Step Counter Sensor not available!");
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 1);
            }
        }

        setupChart();
    }

    private void setupChart() {
        pieChart.setUsePercentValues(false);
        pieChart.setDrawHoleEnabled(false);
        Description desc = new Description();
        desc.setText("Activity Stats");
        pieChart.setDescription(desc);
        pieChart.setTransparentCircleRadius(58f);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (isSensorPresent) {
            stepCount = (int) event.values[0];
            stepText.setText("Steps: " + stepCount);

            float distance = stepCount * 0.78f; // in cm
            float calories = stepCount * 0.04f;

            distanceText.setText("Distance: " + String.format("%.2f", distance / 100000) + " km");
            calorieText.setText("Calories: " + String.format("%.1f", calories) + " kcal");

            updateChart(stepCount, calories);
        }
    }

    private void updateChart(float steps, float calories) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(steps, "Steps"));
        entries.add(new PieEntry(calories, "Calories"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);
        data.setValueTextSize(16f);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    protected void onResume() {
        super.onResume();
        if (stepSensor != null)
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (stepSensor != null)
            sensorManager.unregisterListener(this);
    }
}