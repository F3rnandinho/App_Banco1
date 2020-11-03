package com.example.app_banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button btn;
    private EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);
        edit1 = (EditText)findViewById(R.id.user);
        edit2 = (EditText)findViewById(R.id.pass);


        progress.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String v_user = edit1.getText().toString();
                String v_pass = edit2.getText().toString();

                    new Task().execute();

            }

        });

    }

    class Task extends AsyncTask<String, Void, String> {


        String v_user = edit1.getText().toString();
        String v_pass = edit2.getText().toString();



        @Override
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
            btn.setEnabled(false);

        }

        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i<=10; i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);
            btn.setEnabled(true);

            if (v_user.equalsIgnoreCase("android") && v_pass.equals("123"))
            {
                Intent i = new Intent(getBaseContext(), Home_act.class);
                startActivity(i);
            }

            else
            {
                Toast.makeText(getApplicationContext(), "Usuario o Contraseña Errónea", Toast.LENGTH_SHORT).show();
            }


        }
    }

}


