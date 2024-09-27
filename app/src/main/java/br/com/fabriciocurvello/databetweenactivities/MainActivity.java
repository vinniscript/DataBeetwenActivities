package br.com.fabriciocurvello.databetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etIdade;
    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etIdade = findViewById(R.id.et_idade);
        btEnviar = findViewById(R.id.bt_enviar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Capturar a idade que está no EitText e converter para inteiro.
                int idade;

                try {
                    idade = Integer.parseInt(etIdade.getText().toString());
                } catch (NumberFormatException e) {
                    idade = 0;
                }

                Toast.makeText(MainActivity.this, "Número selecionado" + idade, Toast.LENGTH_SHORT).show();

                // Iniciar a SegundaActivity
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                // Passar dados pela Intent
                intent.putExtra("idadeInserida", idade);

                // Iniciar a intent
                startActivity(intent);
            }
        });

    } // onCreate()

    @Override
    protected void onResume() {
        super.onResume();

        etIdade.setText("");
    }
}