package com.example.pi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import Adaptador.PersonaAdapter;
import Modelos.Persona;
import Utiles.ErrorLog;
import kotlin.jvm.internal.MagicApiIntrinsics;

public class MainActivity extends AppCompatActivity {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private FirebaseFirestore mfirestore;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfirestore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance();


        // Agregar el listener al botón de inicio de sesión
       /* mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });*/
    }

    public void iniciarSesion(View view){
        mEmailEditText = findViewById(R.id.txtCorreo);
        mPasswordEditText = findViewById(R.id.txtPass);

        String correo = ((EditText) findViewById(R.id.txtCorreo)).getText().toString().trim();
        String clave = ((EditText) findViewById(R.id.txtPass)).getText().toString().trim();


        // Validar si los campos están vacíos
        /*if (TextUtils.isEmpty(correo)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }

        if (TextUtils.isEmpty(clave)) {
            mPasswordEditText.setError("Ingresa tu contraseña");
            return;
        }*/

        String[] bandera = {"No existe", ""};


        mfirestore.collection("user").whereEqualTo("correo",correo)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            task.getResult();

                            for(QueryDocumentSnapshot document : task.getResult()) {
                                bandera[0] = "Existe";
                                bandera[1] = document.getData().get("contraseña").toString();
                                validarDatos(bandera[0], bandera[1]);
                                //Log.d("Estado", bandera[0] + " " + correo + " " + bandera[1]);
                          }
                        }
                    }
                });


        //Toast.makeText(this, "correo: " + correo + " Clave:" + bandera[1], Toast.LENGTH_SHORT).show();

        /*if(bandera[0] == "Existe" && clave == bandera[1]){
            Toast.makeText(this, "Inicio de sesión", Toast.LENGTH_SHORT).show();
        }else if(bandera[0] == "No existe"){
            Toast.makeText(this, "Usuario y/o Clave incorrectos", Toast.LENGTH_SHORT).show();
        }*/



        /*String value = dataSnapshot.child("nombre_de_la_propiedad").getValue(String.class);

        Query query = mfirestore.collection("user");

        query.get("");

        // Verificar si el correo electrónico y la contraseña son correctos
        if (email.equals("jordyrivas15@gmail.com") && password.equals("jordy99")) {
            // La autenticación es exitosa, redirigir al usuario a la actividad principal
            Toast.makeText(this, "Sesion iniciada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), menu_principal.class);
            intent.putExtra("id", email);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }*/

    }

    public void validarDatos(String estado, String clave){
        mEmailEditText = findViewById(R.id.txtCorreo);
        mPasswordEditText = findViewById(R.id.txtPass);

        String correo = ((EditText) findViewById(R.id.txtCorreo)).getText().toString().trim();
        String claveWr = ((EditText) findViewById(R.id.txtPass)).getText().toString().trim();


        if(claveWr.equals(clave)){
            Log.d("Prueba: ", "Iguales");
        }else{
            Log.d("Prueba: ", "xD");
        }
        /*if(estado == "Existe"){
            Log.d("Prueba: ", estado + " " + estado + " " + clave + " Iniciar sesión");
        }else if(estado == "No existe"){
            Log.d("Prueba: ", "Usuario y/o clave incorrectos");
        }*/
    }

    public void crearUsuario(View view){
        String nombre = ((EditText) findViewById(R.id.nombre_edit_text)).getText().toString().trim();
        String edad = ((EditText) findViewById(R.id.edad_edit_text)).getText().toString().trim();
        String correo = ((EditText) findViewById(R.id.email_edit_text)).getText().toString().trim();
        String contraseña = ((EditText) findViewById(R.id.password_edit_text)).getText().toString().trim();
        String telefono = ((EditText) findViewById(R.id.telefono_edit_text)).getText().toString().trim();
        String altura = ((EditText) findViewById(R.id.altural_edit_text)).getText().toString().trim();
        String identificacion = ((EditText) findViewById(R.id.identidicacion_edit_text)).getText().toString().trim();

        if (TextUtils.isEmpty(nombre)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }

        if (TextUtils.isEmpty(edad)) {
            mPasswordEditText.setError("Ingresa tu contraseña");
            return;
        }
        if (TextUtils.isEmpty(correo)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }
        if (TextUtils.isEmpty(contraseña)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }
        if (TextUtils.isEmpty(telefono)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }
        if (TextUtils.isEmpty(altura)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }
        if (TextUtils.isEmpty(identificacion)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }

        datosPersona(nombre, edad, correo, contraseña, telefono, altura, identificacion);
        Intent intent = new Intent(getApplicationContext(), menu_principal.class);
        intent.putExtra("id", correo);
        startActivity(intent);

    }


    private void datosPersona(String nombre, String edad, String correo, String contraseña, String telefono, String altura, String identificacion){
        Map<String, Object> map =  new HashMap<>();
        map.put("nombre",nombre);
        map.put("edad",edad);
        map.put("correo",correo);
        map.put("contraseña",contraseña);
        map.put("telefono",telefono);
        map.put("altura",altura);
        map.put("identificacion",identificacion);

        mfirestore.collection("user").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this, "Cuenta creada", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*private void iniciarSesion() {
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        // Validar si los campos están vacíos
        if (TextUtils.isEmpty(email)) {
            mEmailEditText.setError("Ingresa tu correo electrónico");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.setError("Ingresa tu contraseña");
            return;
        }

        // Verificar si el correo electrónico y la contraseña son correctos
        if (email.equals("usuario@example.com") && password.equals("contraseña")) {
            // La autenticación es exitosa, redirigir al usuario a la actividad principal
            Intent intent = new Intent(getApplicationContext(), menu_principal.class);
            intent.putExtra("cadena", mEmailEditText.toString());
            startActivity(intent);
            finish();
        }
    }*/
}
