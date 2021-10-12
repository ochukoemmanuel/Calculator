package com.ebeatsz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView workingsTv;
    private TextView resultTv;

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextView();
    }

    private void initTextView() {

        workingsTv = findViewById(R.id.workingsTextView);
        resultTv = findViewById(R.id.resultTextView);
    }

    public void setWorkingsTv(String givenValue){
        workings += givenValue;
        workingsTv.setText(workings);
    }

    public void equals(View view) {
    }

    public void clearOnClick(View view) {
        workingsTv.setText("");
        workings = "";
        resultTv.setText("");
    }

    public void bracket(View view) {
    }

    public void power(View view) {
        setWorkingsTv("^");
    }

    public void divide(View view) {
        setWorkingsTv("/");
    }

    public void seven(View view) {
        setWorkingsTv("7");
    }

    public void eight(View view) {
        setWorkingsTv("8");
    }

    public void nine(View view) {
        setWorkingsTv("9");
    }

    public void multiply(View view) {
        setWorkingsTv("*");
    }

    public void four(View view) {
        setWorkingsTv("4");
    }

    public void five(View view) {
        setWorkingsTv("5");
    }

    public void six(View view) {
        setWorkingsTv("6");
    }

    public void minus(View view) {
        setWorkingsTv("-");
    }

    public void one(View view) {
        setWorkingsTv("1");
    }

    public void two(View view) {
        setWorkingsTv("2");
    }

    public void three(View view) {
        setWorkingsTv("3");
    }

    public void plus(View view) {
        setWorkingsTv("+");
    }

    public void dot(View view) {
        setWorkingsTv(".");
    }

    public void zero(View view) {
        setWorkingsTv("0");
    }
}