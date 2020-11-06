package com.juan.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activida2 extends AppCompatActivity {

    TextView tvnombre, tvfechanacimiento, tvtelefono, tvcorreo, tvdescripcion;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activida2);

        tvnombre = (TextView)findViewById(R.id.tvnombre);
        tvfechanacimiento = (TextView)findViewById(R.id.tvFecha);
        tvtelefono = (TextView)findViewById(R.id.tvTelefono);
        tvcorreo = (TextView)findViewById(R.id.tvCorreo);
        tvdescripcion = (TextView)findViewById(R.id.tvDescripcion);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activida2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        mostraDato();
    }

    private void mostraDato() {
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("nom");
        String fecha = datos.getString("fechnac");
        String telfono = datos.getString("telf");
        String email = datos.getString("email");
        String descripcion = datos.getString("desc");

        tvnombre.setText(nombre);
        tvfechanacimiento.setText(fecha);
        tvtelefono.setText(telfono);
        tvcorreo.setText(email);
        tvdescripcion.setText(descripcion);

    }
}