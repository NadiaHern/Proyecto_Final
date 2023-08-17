package com.example.oficina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    Button btnfoco, btnsocket, btncerradura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnfoco = (Button) findViewById(R.id.btnfoco);
        btnsocket = (Button) findViewById(R.id.btnsocket);
        btncerradura = (Button) findViewById(R.id.btncerradura);

        btnfoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luz();
            }
        });

        btnsocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socket();
            }
        });

        btncerradura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerradura();
            }
        });
    }

    public void luz(){
        Intent siguiente=new Intent(menu.this, luz_inteligente.class);
        startActivity(siguiente);
    }

    public void socket(){
        Intent siguiente=new Intent(menu.this, socket_inteligente.class);
        startActivity(siguiente);
    }

    public void cerradura(){
        Intent siguiente=new Intent(menu.this, cerradura_inteligente.class);
        startActivity(siguiente);
    }
}