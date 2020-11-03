package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Creditos;

public class Prestamos_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spin1 = (Spinner) findViewById(R.id.spnClientes);
        spin2 = (Spinner) findViewById(R.id.spnCreditos);
        text = (TextView) findViewById(R.id.tv);


        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void CalcularPrestamo(View view) {
        String clientes = spin1.getSelectedItem().toString();
        String creditos = spin2.getSelectedItem().toString();


        Creditos credito = new Creditos();
        Clientes clnte = new Clientes();


        if (clientes.equals("Axel") && creditos.equals("Credito Hipotecario")) {
            int r = credito.getHipotecario() + clnte.getAxel();
            text.setText("El Saldo final es: " + r);

        }
        if (clientes.equals("Axel") && creditos.equals("Credito Automotriz")) {
            int r = credito.getAutomotriz() + clnte.getAxel();
            text.setText("El Saldo final es: " + r);

        }
        if (clientes.equals("Roxana") && creditos.equals("Credito Automotriz")) {

            int r = credito.getAutomotriz() + clnte.getRoxana();
            text.setText("El Saldo final es: " + r);

        }
        if (clientes.equals("Roxana") && creditos.equals("Credito Hipotecario")) {

            int r = credito.getHipotecario() + clnte.getRoxana();
            text.setText("El Saldo final es: " + r);

        }
    }

    public void CalcularDeuda(View view) {
        String clientes = spin1.getSelectedItem().toString();
        String creditos = spin2.getSelectedItem().toString();


        Creditos credito = new Creditos();
        Clientes clnte = new Clientes();


        if (clientes.equals("Axel") && creditos.equals("Credito Hipotecario")) {
            int r = credito.getHipotecario() + clnte.getAxel();
            int d = r / 12;
            text.setText("Debera Pagar Mensualmente: " + d);

        }
        if (clientes.equals("Axel") && creditos.equals("Credito Automotriz")) {
            int r = credito.getAutomotriz() + clnte.getAxel();
            int d = r / 8;
            text.setText("Debera Pagar Mensualmente: " + d);

        }
        if (clientes.equals("Roxana") && creditos.equals("Credito Automotriz")) {

            int r = credito.getAutomotriz() + clnte.getRoxana();
            int d = r / 12;
            text.setText("Debera Pagar Mensualmente: " + d);

        }
        if (clientes.equals("Roxana") && creditos.equals("Credito Hipotecario")) {

            int r = credito.getHipotecario() + clnte.getRoxana();
            int d = r / 8;
            text.setText("Debera Pagar Mensualmente: " + d);

        }
    }
}
