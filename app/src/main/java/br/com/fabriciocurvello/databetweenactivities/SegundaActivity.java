package br.com.fabriciocurvello.databetweenactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SegundaActivity extends AppCompatActivity {

    private TextView tvIdade;
    private TextView tvSituacao;
    private Button btRetornar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvIdade = findViewById(R.id.tv_idade);
        tvSituacao = findViewById(R.id.tv_situacao);
        btRetornar = findViewById(R.id.bt_retornar);

        // Recuperar os dados que foram enviados pela intent (da outra activity para cá)

        Bundle dados = getIntent().getExtras();
        int idade = dados.getInt("idadeInserida");

        // Inserindo a idade recuperada no TextView. Convertendo para texto, pois o TextView trabalha apenas com string
        tvIdade.setText( String.valueOf(idade) );

        // Verificando se é menor ou maior de idade para exibir na tvSituacao
        if ( idade == 0) {
            tvSituacao.setText("Isso é estranho...");
        } else if (idade < 18) {
            tvSituacao.setText("Você é menor de idade.");
            } else{
            tvSituacao.setText("Você é maior de idade.");
            }

        btRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Encerra esta Activity
            }
        });


    } // onCreate
}