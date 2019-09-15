package br.com.calcularimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView viewImgIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        Button btnCalcula = findViewById(R.id.btnCalcularIMC);
        viewImgIMC = findViewById(R.id.imgView);

        btnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText viewPeso = findViewById(R.id.txtPeso);
                EditText viewAltura = findViewById(R.id.txtAltura);

                String peso = viewPeso.getText().toString();
                String altura = viewAltura.getText().toString();

                if (!TextUtils.isEmpty(peso) && !TextUtils.isEmpty(altura)) {
                    calcularIMC(peso, altura);
                } else {
                    viewImgIMC.setImageResource(R.drawable.ic_launcher_background);
                    final String message = "Informe o seu peso e sua altura para calcular o IMC";
                    Toast toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    public void calcularIMC(String strPeso, String strAltura) {

        int imgIMC = 0;
        TextView viewIMC = findViewById( R.id.viewIMC );
        float peso = Float.valueOf(strPeso);
        float altura = Float.valueOf(strAltura);
        float imc = peso / (altura * altura);

        if (imc <= 18.5) {
            imgIMC = R.drawable.magrelo;
        } else if (imc > 18.5 && imc < 25.0) {
            imgIMC = R.drawable.normal;
        } else if (imc >= 25.0 && imc < 30.0) {
            imgIMC = R.drawable.sobrepeso;
        } else if (imc >= 30.0 && imc < 35.0) {
            imgIMC = R.drawable.gordo;
        } else if (imc >= 35.0) {
            imgIMC = R.drawable.obeso;
        }
        viewIMC.setText(String.valueOf(imc));
        viewImgIMC.setImageResource(imgIMC);
    }
}
