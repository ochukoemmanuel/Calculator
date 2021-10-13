package com.ebeatsz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    private TextView workingsTv;
    private TextView resultTv;

    String workings = "";
    String formula = "";
    String tempFormula = "";

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
        workings = workings + givenValue;
        workingsTv.setText(workings);
    }

    public void equals(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        try {
            if (!workings.equals("")){
                result = (double)engine.eval(workings);
            }
        } catch (ScriptException e){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (result != null){
            resultTv.setText(String.valueOf(result.doubleValue()));
        }

    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++){
            if (workings.charAt(i) == '^'){
                indexOfPowers.add(i);
            }
        }

        formula = workings;
        tempFormula = workings;
        for (Integer index : indexOfPowers){
            changeFormula(index);
        }
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < workings.length(); i++){
            if (isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for (int i = index - 1; i >= 0; i++){
            if (isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }

        String original = numberLeft + '^' + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    private boolean isNumeric(char c){
        if ((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public void clearOnClick(View view) {
        workingsTv.setText("");
        workings = "";
        resultTv.setText("0");
    }

    boolean leftBracket = true;
    public void bracket(View view) {
        if (leftBracket){
            setWorkingsTv("(");
            leftBracket = false;
        } else {
            setWorkingsTv(")");
            leftBracket = true;
        }
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