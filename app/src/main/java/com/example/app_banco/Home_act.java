package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.d, R.drawable.e, R.drawable.f};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setAutoStart(true);
        vf.setFlipInterval(2800);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }



    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Seguridad(View view)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }

    public void Prestamos(View view)
    {
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> creditos = new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");

        creditos.add("Credito Hipotecario");
        creditos.add("Credito Automotriz");

        Intent i = new Intent(this, Prestamos_act.class);
        i.putExtra("listaClientes", clientes);
        i.putExtra("listaCreditos", creditos);
        startActivity(i);
    }

    public void Clientes(View view)
    {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }
}