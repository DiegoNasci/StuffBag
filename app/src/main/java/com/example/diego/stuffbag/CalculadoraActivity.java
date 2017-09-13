package com.example.diego.stuffbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    TextView textView;
    String currentString = "0", previusString = null;
    boolean isTempStringShown = false;
    int currentopperand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Código para FullScreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_calculadora);

        textView = (TextView) findViewById(R.id.textView);
        int numberButtons[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        NumberButtonClickListener numberClickListener = new NumberButtonClickListener();
        for (int id : numberButtons) {
            View v = findViewById(id);
            v.setOnClickListener(numberClickListener);
        }
        int opperandButtons[] = {R.id.buttonPlus, R.id.buttonMinus, R.id.buttonDivide, R.id.buttonTimes, R.id.buttonDecimal, R.id.buttonClear, R.id.buttonEquals};
        OpperandButtonClickListener oppClickListener = new OpperandButtonClickListener();
        for (int id : opperandButtons) {
            View v = findViewById(id);
            v.setOnClickListener(oppClickListener);
        }
        setCurrentString("0");

        //Volta Menu
        Button MENU = (Button) findViewById(R.id.button_menu);
        MENU.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CalculadoraActivity.this,
                        MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    void setCurrentString(String s) {
        currentString = s;
        textView.setText(s);
    }

    class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (isTempStringShown) {
                previusString = currentString;
                currentString = "0";
                isTempStringShown = false;
            }
            String text = (String) ((Button) v).getText();
            if (currentString.equals("0")) setCurrentString(text);
            else setCurrentString(currentString + text);
        }
    }

    class OpperandButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.buttonClear) {
                isTempStringShown = false;
                setCurrentString("0");
                previusString = null;
            }
            if (id == R.id.buttonDecimal)
                if (!currentString.contains(".")) setCurrentString(currentString + ".");
            if (id == R.id.buttonPlus || id == R.id.buttonMinus || id == R.id.buttonTimes || id == R.id.buttonDivide) {
                currentopperand = id;
                previusString = currentString;
                isTempStringShown = true;
            }
            if (id == R.id.buttonEquals) {
                double curr = Double.parseDouble(currentString);
                double result = 0;
                if (previusString != null) {
                    double prev = Double.parseDouble(previusString);
                    switch (currentopperand) {
                        case R.id.buttonPlus:
                            result = prev + curr;
                            break;
                        case R.id.buttonMinus:
                            result = prev - curr;
                            break;
                        case R.id.buttonTimes:
                            result = prev * curr;
                            break;
                        case R.id.buttonDivide:
                            result = prev / curr;
                            break;
                    }
                }
                setCurrentString(Double.toString(result));
            }
        }
    }
}
