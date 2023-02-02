package com.example.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button b3;
    EditText etReceptor,etAsunto,etCuerpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);

        b3=findViewById(R.id.b3);

        etAsunto=findViewById(R.id.etAsunto);
        etReceptor=findViewById(R.id.etReceptor);
        etCuerpo=findViewById(R.id.etCuerpo);

        //Método para el botón de enviar un mensaje
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                //Configuramos a dónde queremos mandar el dato
                intent.setData(Uri.parse("mailto:"));
                //Configuramos el email
                intent.putExtra(Intent.EXTRA_EMAIL,etReceptor.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT,etAsunto.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etCuerpo.getText().toString());
                //Empezamos la acción
                startActivity(intent);
            }
        });


    }

    public void abrirNavegador(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        //Configuramos el intent para indicar la dirección a acceder
        intent.setData(Uri.parse("https://www.google.es"));
        //Arrancar la acción
        startActivity(intent);
    }

    public void compartirTexto(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        //Configuramos el intent
        intent.setType("text/plain");
        //Pasamos los datos
        intent.putExtra(Intent.EXTRA_TEXT,tv.getText().toString());

        //Forzar la selección
        Intent intentConEleccion=Intent.createChooser(intent,"¿Qué aplicación quieres usar para compartir el texto?");

        //Empezar la acción
        startActivity(intentConEleccion);


    }
}