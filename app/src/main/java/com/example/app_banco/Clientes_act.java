package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edcodigo = (EditText)findViewById(R.id.et_codigo);
        ednombre = (EditText)findViewById(R.id.et_nombre);
        edsalario = (EditText)findViewById(R.id.et_salario);

    }

    public void GuardarCliente(View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(!edcodigo.getText().toString().isEmpty())
        {
            ContentValues cont = new ContentValues();

            cont.put("codigo", edcodigo.getText().toString());
            cont.put("nombre", ednombre.getText().toString());
            cont.put("salario", edsalario.getText().toString());

            db.insert("gestion", null, cont);
            db.close();

            Toast.makeText(this, "Se ha Guardado un Cliente", Toast.LENGTH_LONG).show();

            edcodigo.setText("");
            ednombre.setText("");
            edsalario.setText("");
        }
        else
        {
            Toast.makeText(this, "Debe ingresar el Codigo del Cliente", Toast.LENGTH_LONG).show();
        }

    }
    public void MostrarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM gestion WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                ednombre.setText(fila.getString(0));
                edsalario.setText(fila.getString(1));
            } else {

                Toast.makeText(this, "No hay Cliente Existente", Toast.LENGTH_LONG).show();

            }
        }
        else
        {
            Toast.makeText(this, "No hay Cliente con el Codigo Asociado", Toast.LENGTH_LONG).show();
        }

    }
    public void EliminarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        db.delete("gestion", "codigo="+codigo, null);
        db.close();

        Toast.makeText(this, "Has Borrado un Cliente", Toast.LENGTH_LONG).show();

        edcodigo.setText("");
        ednombre.setText("");
        edsalario.setText("");


    }
    public void Actualizar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edcodigo.getText().toString());
        cont.put("nombre", ednombre.getText().toString());
        cont.put("salario", edsalario.getText().toString());

        if(codigo.isEmpty())
        {

            db.update("gestion", cont,"codigo="+codigo, null);
            db.close();
            Toast.makeText(this, "Has Actualizado", Toast.LENGTH_LONG).show();
        }

    }

}