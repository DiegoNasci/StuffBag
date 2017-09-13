package com.example.diego.stuffbag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button CALCULAR;
    private EditText peso;
    private EditText altura;
    private String sexo;
    private Spinner spinner;
    private double peso1;
    private double altura1;
    private double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.imc_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        peso = (EditText) findViewById(R.id.editText_peso);
        altura = (EditText) findViewById(R.id.editText_altura);
        CALCULAR = (Button) findViewById(R.id.button_calc_imc);
        CALCULAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (altura.getText().length() != 0 &&
                        peso.getText().length() != 0) {
                    peso1 = Double.parseDouble(peso.getText().toString());
                    altura1 = Double.parseDouble(altura.getText().toString());
                    imc = peso1 / (altura1 * altura1);
                } else {
                    Toast.makeText(getApplicationContext(), "INFORME OS CAMPOS", Toast.LENGTH_LONG).show();
                }
                if (sexo.length() == 8) {
                    if (imc <= 19) {
                        Intent intent = new Intent(IMCActivity.this,
                                MuitoAbaixoPesoActivity.class);
                        intent.putExtra("resultado", imc);
                        startActivity(intent);
                    } else if (imc >= 19.1 && imc <= 25.8) {
                        Intent intent = new Intent(IMCActivity.this,
                                AbaixoPesoActivity.class);
                        intent.putExtra("resultado", imc);
                        startActivity(intent);
                    } else if (imc >= 25.9 && imc <= 27.3) {
                        Intent intent = new Intent(IMCActivity.this,
                                PesoNormalActivity.class);
                        intent.putExtra("resultado", imc);
                        startActivity(intent);
                    } else if (imc >= 27.4 && imc <= 32.3) {
                        Intent intent = new Intent(IMCActivity.this,
                                AcimaPesoActivity.class);
                        intent.putExtra("resultado", imc);
                        startActivity(intent);
                    } else if (imc >= 32.4) {
                        Intent intent = new Intent(IMCActivity.this,
                                Obesidade3Activity.class);
                        intent.putExtra("resultado", imc);
                        startActivity(intent);
                    }
                }
                if (sexo.length() == 9) {
                    if(imc <= 20.7){
                        Intent intent = new Intent(IMCActivity.this,
                                MuitoAbaixoPesoActivity.class);
                            intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 20.8 && imc <= 26.4){
                        Intent intent = new Intent(IMCActivity.this,
                                AbaixoPesoActivity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 26.5 && imc <= 27.8){
                        Intent intent = new Intent(IMCActivity.this,
                                PesoNormalActivity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 27.9 && imc <= 31.1){
                        Intent intent = new Intent(IMCActivity.this,
                                AcimaPesoActivity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 31.2){
                        Intent intent = new Intent(IMCActivity.this,
                                Obesidade3Activity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }
                }
                if (sexo.length() == 5) {
                    if(imc <= 17){
                        Intent intent = new Intent(IMCActivity.this,
                                MuitoAbaixoPesoActivity.class);
                            intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 17.1 && imc <= 18.4){
                        Intent intent = new Intent(IMCActivity.this,
                                AbaixoPesoActivity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 18.5 && imc <= 24.9){
                        Intent intent = new Intent(IMCActivity.this,
                                PesoNormalActivity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 25 && imc <= 29.9){
                        Intent intent = new Intent(IMCActivity.this,
                                AcimaPesoActivity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 30 && imc <= 34.9){
                        Intent intent = new Intent(IMCActivity.this,
                               Obesidade1Activity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 35 && imc <= 39.9){
                        Intent intent = new Intent(IMCActivity.this,
                                Obesidade2Activity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }else if(imc >= 40){
                        Intent intent = new Intent(IMCActivity.this,
                                Obesidade3Activity.class);
                        intent.putExtra("resultado",imc);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        sexo = spinner.getSelectedItem().toString();
           // Toast.makeText(parent.getContext(), sexo, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }

}
