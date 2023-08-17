package com.example.oficina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timeTextView;
    private TextView welcomeTextView;
    private Animation fadeInAnimation;
    private Handler handler;
    private Runnable updateTimeRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = findViewById(R.id.timeTextView);
        welcomeTextView = findViewById(R.id.welcomeTextView);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        timeTextView.setText(currentTime);

        fadeInAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Realizar la animación del fondo primero
        findViewById(android.R.id.content).startAnimation(fadeInAnimation);

        // Usar un Handler para mostrar el mensaje y la hora después de 3 segundos
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Realizar la animación de desvanecimiento para el mensaje y la hora
                timeTextView.startAnimation(fadeInAnimation);
                welcomeTextView.startAnimation(fadeInAnimation);

                // Pasar a otra actividad después de 2 segundos (2000 ms)
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, menu.class));
                        finish(); // Opcional: para finalizar esta actividad después de abrir la nueva
                    }
                }, 2000); // Retrasar el inicio de la nueva actividad durante 2 segundos (2000 ms)
            }
        }, 0000); // Retrasar la transición de mensaje y hora durante 3 segundos (3000 ms)

        // Actualizar la hora periódicamente cada segundo
        updateTimeRunnable = new Runnable() {
            @Override
            public void run() {
                updateCurrentTime();
                handler.postDelayed(this, 1000); // Repetir cada segundo (1000 ms)
            }
        };
        handler.post(updateTimeRunnable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Detener la actualización de la hora y la transición al pausar la actividad
        handler.removeCallbacks(updateTimeRunnable);
        handler.removeCallbacksAndMessages(null);
    }

    // Método para actualizar la hora actual en el TextView
    private void updateCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        timeTextView.setText(currentTime);
    }
}