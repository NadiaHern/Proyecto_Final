package com.example.oficina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class socket_inteligente extends AppCompatActivity {

    private SwitchCompat switchCompat1, switchCompat2, switchCompat3;
    private ImageView ivestado1, ivestado2, ivestado3;
    private TextView tvestado1, tvestado2, tvestado3, tvnombre1, tvnombre2, tvnombre3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_inteligente);

        switchCompat1 = findViewById(R.id.switchCompat1);
        switchCompat2 = findViewById(R.id.switchCompat2);
        switchCompat3 = findViewById(R.id.switchCompat3);
        ivestado1 = findViewById(R.id.ivestado1);
        ivestado2 = findViewById(R.id.ivestado2);
        ivestado3 = findViewById(R.id.ivestado3);
        tvestado1 = findViewById(R.id.tvestado1);
        tvestado2 = findViewById(R.id.tvestado2);
        tvestado3 = findViewById(R.id.tvestado3);
        tvnombre1 = findViewById(R.id.tvnombre1);
        tvnombre2 = findViewById(R.id.tvnombre2);
        tvnombre3 = findViewById(R.id.tvnombre3);


        SharedPreferences preferences = getSharedPreferences("SocketNames", MODE_PRIVATE);
        String name1 = preferences.getString("name1", "Enchufe 1");
        String name2 = preferences.getString("name2", "Enchufe 2");
        String name3 = preferences.getString("name3", "Enchufe 3");

        tvnombre1.setText(name1);
        tvnombre2.setText(name2);
        tvnombre3.setText(name3);

        switchCompat1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivestado1.setImageResource(R.drawable.encendidosocket);
                    tvestado1.setText("ON");
                } else {
                    ivestado1.setImageResource(R.drawable.apagadosocket);
                    tvestado1.setText("OFF");
                }
            }
        });

        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ivestado2.setImageResource(R.drawable.encendidosocket);
                    tvestado2.setText("ON");
                } else {
                    ivestado2.setImageResource(R.drawable.apagadosocket);
                    tvestado2.setText("OFF");
                }
            }
        });

        switchCompat3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ivestado3.setImageResource(R.drawable.encendidosocket);
                    tvestado3.setText("ON");
                } else {
                    ivestado3.setImageResource(R.drawable.apagadosocket);
                    tvestado3.setText("OFF");
                }
            }
        });


        tvnombre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditNameDialog(tvnombre1);
            }
        });

        tvnombre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditNameDialog(tvnombre2);
            }
        });

        tvnombre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditNameDialog(tvnombre3);
            }
        });

    }

    private void showEditNameDialog(final TextView textView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_edit_name, null);
        builder.setView(dialogView);

        final EditText editTextName = dialogView.findViewById(R.id.editTextName);
        Button buttonSave = dialogView.findViewById(R.id.buttonSave);

        editTextName.setText(textView.getText());

        final AlertDialog dialog = builder.create();
        dialog.show();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editTextName.getText().toString();
                textView.setText(newName);

                // Guardar el nuevo nombre en las preferencias compartidas
                SharedPreferences preferences = getSharedPreferences("SocketNames", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                if (textView == tvnombre1) {
                    editor.putString("name1", newName);
                } else if (textView == tvnombre2) {
                    editor.putString("name2", newName);
                } else if (textView == tvnombre3) {
                    editor.putString("name3", newName);
                }
                editor.apply();
                dialog.dismiss();
            }
        });
    }
}