package com.juan.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Obtener referencia al EditText
    private EditText etFecha;

    // Guardar el último año, mes y día del mes
    private int ultimoAnio, ultimoMes, ultimoDiaDelMes;

    // Crear un listener del datepicker;
    private DatePickerDialog.OnDateSetListener listenerDeDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anio, int mes, int diaDelMes) {
            // Esto se llama cuando seleccionan una fecha. Nos pasa la vista, pero más importante, nos pasa:
            // El año, el mes y el día del mes. Es lo que necesitamos para saber la fecha completa

            // Refrescamos las globales
            ultimoAnio = anio;
            ultimoMes = mes;
            ultimoDiaDelMes = diaDelMes;

            // Y refrescamos la fecha
            refrescarFechaEnEditText();

        }
    };

    public void refrescarFechaEnEditText() {
        // Formateamos la fecha pero podríamos hacer cualquier otra cosa ;)
        String fecha = String.format(Locale.getDefault(), "%02d-%02d-%02d", ultimoDiaDelMes, ultimoMes+1, ultimoAnio );

        // La ponemos en el editText
        etFecha.setText(fecha);
    }

    EditText nombreCompleto, fechaNacimiento, telefono, correo, descripcion;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar objetos
        etFecha = findViewById(R.id.etFecha);

        // Poner último año, mes y día a la fecha de hoy
        final Calendar calendario = Calendar.getInstance();
        ultimoAnio = calendario.get(Calendar.YEAR);
        ultimoMes = calendario.get(Calendar.MONTH);
        ultimoDiaDelMes = calendario.get(Calendar.DAY_OF_MONTH);

        // Refrescar la fecha en el EditText
        refrescarFechaEnEditText();

        // Hacer que el datepicker se muestre cuando toquen el EditText; recuerda
        // que se podría invocar en el click de cualquier otro botón, o en cualquier
        // otro evento

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí es cuando dan click así que mostramos el DatePicker

                // Le pasamos lo que haya en las globales
                DatePickerDialog dialogoFecha = new DatePickerDialog(MainActivity.this, listenerDeDatePicker, ultimoAnio, ultimoMes, ultimoDiaDelMes);
                //Mostrar
                dialogoFecha.show();
            }
        });


        nombreCompleto   = (EditText)findViewById(R.id.editNombreCompleto);
        fechaNacimiento   = (EditText)findViewById(R.id.etFecha);

        telefono     = (EditText)findViewById(R.id.editTelefono);
        correo   = (EditText)findViewById(R.id.editCorreo);
        descripcion   = (EditText)findViewById(R.id.editDescripcion);
        siguiente  = (Button) findViewById(R.id.btnSiguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nom   = nombreCompleto.getText().toString();
                String fechnac   = fechaNacimiento.getText().toString();

                String telf    = telefono.getText().toString();
                String email = correo.getText().toString();
                String desc = descripcion.getText().toString();
                Intent i = new Intent(MainActivity.this, Activida2.class);

                i.putExtra("nom", nom);
                i.putExtra("fechnac", fechnac);
                i.putExtra("telf", telf);
                i.putExtra("email", email);
                i.putExtra("desc", desc);

                startActivity(i);
            }
        });
    }
}