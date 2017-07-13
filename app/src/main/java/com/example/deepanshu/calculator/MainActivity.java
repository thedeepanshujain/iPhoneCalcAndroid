package com.example.deepanshu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView inputData;

    float input1;
    float input2;
    boolean ifViewed = false;
    boolean ifAdd = false;
    boolean ifSub = false;
    boolean ifDiv = false;
    boolean ifMul = false;

    Button num0;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;

    Button div;
    Button mul;
    Button add;
    Button sub;
    Button equ;

    public void checkOperation(){
        if(ifDiv){
            input2 = Float.parseFloat(inputData.getText().toString());
            if(input2==0){
                Toast.makeText(MainActivity.this,"Do it yourself !!",Toast.LENGTH_LONG).show();
                inputData.setText("0");
                return;
            }
            input1 /= input2;
            ifDiv = false;

        }else if(ifMul){
            input2 = Float.parseFloat(inputData.getText().toString());
            input1 *= input2;
            ifMul = false;

        }else if(ifAdd){
            input2 = Float.parseFloat(inputData.getText().toString());
            input1 += input2;
            ifAdd = false;

        }else if(ifSub){
            input2 = Float.parseFloat(inputData.getText().toString());
            input1 -= input2;
            ifSub = false;

        }else{
            input1 = Float.parseFloat(inputData.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData = (TextView) findViewById(R.id.input);

        Button clrs = (Button) findViewById(R.id.clear);
        clrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData.setText("0");
            }
        });

        num0 = (Button) findViewById(R.id.number0);
        num0.setOnClickListener(this);

        num1 = (Button) findViewById(R.id.number1);
        num1.setOnClickListener(this);

        num2 = (Button) findViewById(R.id.number2);
        num2.setOnClickListener(this);

        num3 = (Button) findViewById(R.id.number3);
        num3.setOnClickListener(this);

        num4 = (Button) findViewById(R.id.number4);
        num4.setOnClickListener(this);

        num5 = (Button) findViewById(R.id.number5);
        num5.setOnClickListener(this);

        num6 = (Button) findViewById(R.id.number6);
        num6.setOnClickListener(this);

        num7 = (Button) findViewById(R.id.number7);
        num7.setOnClickListener(this);

        num8 = (Button) findViewById(R.id.number8);
        num8.setOnClickListener(this);

        num9 = (Button) findViewById(R.id.number9);
        num9.setOnClickListener(this);

        Button decimal = (Button) findViewById(R.id.point);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifViewed){
                    ifViewed = false;
                    inputData.setText("0.");
                    return;
                }

                String currentInputString = inputData.getText().toString();
                if(currentInputString.contains(".")){
                    return;
                }

                inputData.setText(inputData.getText().toString()+ ".");
            }
        });

        Button negate = (Button) findViewById(R.id.negation);
        negate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float toNegate = Float.parseFloat(inputData.getText().toString());
                toNegate = (-1)*toNegate;
                inputData.setText(toNegate+" ");
            }
        });

        Button percent = (Button) findViewById(R.id.by100);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float toPercent = Float.parseFloat(inputData.getText().toString());
                toPercent /= 100;
                inputData.setText(toPercent + "");
            }
        });

        div = (Button) findViewById(R.id.divide);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOperation();
                inputData.setText("0");
                ifDiv = true;
            }
        });

        mul = (Button) findViewById(R.id.multiply);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOperation();
                inputData.setText("0");
                ifMul = true;
            }
        });

        add = (Button) findViewById(R.id.addition);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOperation();
                inputData.setText("0");
                ifAdd = true;
            }
        });

        sub = (Button) findViewById(R.id.subtract);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOperation();
                inputData.setText("0");
                ifSub = true;
            }
        });

        equ = (Button) findViewById(R.id.equals);
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOperation();
                inputData.setText(input1+"");
                ifViewed = true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int currentNum = 0;
        Button num = (Button) v;
        if(num==num0)   currentNum=0;
        else if(num==num1)   currentNum=1;
        else if(num==num2)   currentNum=2;
        else if(num==num3)   currentNum=3;
        else if(num==num4)   currentNum=4;
        else if(num==num5)   currentNum=5;
        else if(num==num6)   currentNum=6;
        else if(num==num7)   currentNum=7;
        else if(num==num8)   currentNum=8;
        else if(num==num9)   currentNum=9;
        Log.i("Log", "currentNum"+currentNum);
        if(ifViewed){
            ifViewed = false;
            inputData.setText(currentNum+"");
            return;
        }

        String currentInputString = inputData.getText().toString();
        Log.i("Log2", "StringDecimal" + currentInputString);
        if(currentInputString.contains(".")){
            inputData.setText(inputData.getText().toString()+currentNum);
            return;
        }

        float currentInput = Float.parseFloat(currentInputString);
        if(currentInput==0){
            inputData.setText(currentNum+"");
        }else{
            inputData.setText(inputData.getText().toString()+currentNum);
        }

    }
}