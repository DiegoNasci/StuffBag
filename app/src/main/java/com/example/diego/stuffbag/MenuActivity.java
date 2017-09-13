package com.example.diego.stuffbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button IMC;
    private Button CALCULADORA;
    private Button FORMULAS;
    private Button MEDIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Botão IMC
        IMC = (Button) findViewById(R.id.button_imc);
        IMC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,
                        IMCActivity.class);
                startActivity(intent);
            }
        });

        //Botão CALCULADORA
        CALCULADORA = (Button) findViewById(R.id.button_calculadora);
        CALCULADORA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,
                        CalculadoraActivity.class);
                startActivity(intent);
            }
        });

//        //Botão FORMULAS
//        FORMULAS = (Button) findViewById(R.id.button_formulas);
//        FORMULAS.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(MenuActivity.this,
//                        FormulasActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //Botão MEDIA
//        MEDIA = (Button) findViewById(R.id.button_media);
//        MEDIA.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(MenuActivity.this,
//                        MediaActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
