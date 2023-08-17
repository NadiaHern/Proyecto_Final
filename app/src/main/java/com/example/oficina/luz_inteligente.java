package com.example.oficina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class luz_inteligente extends AppCompatActivity {

    private SwitchCompat switchCompat;
    private ImageView imageView;
    private TextView estadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz_inteligente);

        switchCompat = findViewById(R.id.switchCompat);
        imageView = findViewById(R.id.ivestado);
        estadoTextView = findViewById(R.id.tvestado);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(R.drawable.encendido);
                    estadoTextView.setText("Estado Encendido");
                } else {
                    imageView.setImageResource(R.drawable.apagado);
                    estadoTextView.setText("Estado Apagado");
                }
            }
        });

    }
}