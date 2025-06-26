package com.example.tarea3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat

public class MainActivity extends AppCompatActivity {

    EditText etNombres, etApellidos, etEdad, etCorreo, etDireccion;
    Button btnSalvar;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etEdad = findViewById(R.id.etEdad);
        etCorreo = findViewById(R.id.etCorreo);
        etDireccion = findViewById(R.id.etDireccion);
        btnSalvar = findViewById(R.id.btnSalvar);
        dbHelper = new DBHelper(this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = etNombres.getText().toString();
                String apellidos = etApellidos.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                String correo = etCorreo.getText().toString();
                String direccion = etDireccion.getText().toString();

                Persona p = new Persona(nombres, apellidos, edad, correo, direccion);
                dbHelper.insertarPersona(p);
                Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
