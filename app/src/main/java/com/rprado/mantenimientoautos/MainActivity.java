package com.rprado.mantenimientoautos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.rprado.mantenimientoautos.entidades.Automovil;
import com.rprado.mantenimientoautos.entidades.DAOAutomovil;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*DECLARANDO INIT*/
    EditText txtPlaca, txtPropietario, txtMarca, txtFabricacion, txtRepadado;
    RadioGroup radioGroup;
    RadioButton rbtSi, rbtNo;
    Button btnGuardar, btnModificar, btnEliminar;
    ListView lstAutomovil;

    ArrayList<Automovil> listaAutomoviles = new ArrayList<>();
    DAOAutomovil daoAutomovil = new DAOAutomovil(this);
    int id;
    String placa, propietario, marca, fabricacion, reparado;
    Automovil a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daoAutomovil.OpenDB();
        asignarReferencias();

    }

    public void mostrarAutomoviles(){
        listaAutomoviles = daoAutomovil.cargarAutomoviles();
        ArrayList<String> lista = new ArrayList<>();
        for (Automovil aut:listaAutomoviles){
            lista.add(aut.getPlaca()+" "+aut.getPropietario()+" "+aut.getMarca()+" "+aut.getFabricacion()+" "+aut.getReparado());

        }
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        lstAutomovil.setAdapter(adapter);
    }

    private void asignarReferencias() {

        txtPlaca = findViewById(R.id.txtPlaca);
        txtPropietario = findViewById(R.id.txtPropietario);
        txtMarca = findViewById(R.id.txtMarca);
        txtFabricacion = findViewById(R.id.txtFabricacion);
        radioGroup = findViewById(R.id.radioGroup);
        lstAutomovil = findViewById(R.id.lstAutomoviles);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnModificar = findViewById(R.id.btnModificar);
        btnEliminar = findViewById(R.id.btnEliminar);
        capturarEventos();


    }

    private void capturarEventos(){
        final String cad = "";
        btnGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                capturarDatos();
                daoAutomovil.registrarAutomovil(a);
                String cad = "Se ha guardado correctamente:";
                Toast.makeText(getApplicationContext(),cad,Toast.LENGTH_SHORT).show();
                mostrarAutomoviles();
                limpiar();


            }


        });

        lstAutomovil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                a = listaAutomoviles.get(i);
                txtPlaca.setText(a.getPlaca());
                txtPropietario.setText(a.getPropietario());
                txtMarca.setText(a.getMarca());
                txtFabricacion.setText(a.getFabricacion());
                txtRepadado.setText(a.getFabricacion());

                id = a.getId();


            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturarEventos();
                capturarDatos();
                a.setId(id);
                daoAutomovil.modificarAutomovil(a);
                mostrarAutomoviles();
                limpiar();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daoAutomovil.eliminarAutomovil(id);
                mostrarAutomoviles();
                limpiar();
            }
        });




    }

    private  void  capturarDatos(){

        placa = txtPlaca.getText().toString();
        propietario = txtPropietario.getText().toString();
        marca = txtMarca.getText().toString();
        fabricacion = txtFabricacion.getText().toString();

        if (radioGroup.getCheckedRadioButtonId() == R.id.rbtSi){
            reparado = "Si";
        }else {
            reparado = "No";
        }

        a = new Automovil(placa,propietario,marca,fabricacion,reparado);

    }

    private void    limpiar(){
        txtPlaca.setText("");
        txtPropietario.setText("");
        txtMarca.setText("");
        txtFabricacion.setText("");
        txtPlaca.requestFocus();
    }


}