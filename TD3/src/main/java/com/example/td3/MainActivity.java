package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
     Button lancement_de;
     TextView affichage_de;
     TextView deuxieme_de;
     EditText nombre_face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        affichage_de = findViewById(R.id.affiche_valeur_de);
        deuxieme_de = findViewById(R.id.deuxieme_de);
        nombre_face = findViewById(R.id.nombre_face);

        lancement_de = findViewById(R.id.button_lacement_de);
        lancement_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast =  Toast.makeText(MainActivity.this,
                        "De lance",
                        Toast.LENGTH_SHORT);
                toast.show();
                String nb_face = nombre_face.getText().toString();
                if(nb_face.equals("")){
                     Toast.makeText(MainActivity.this,
                            "Entrer un nombre de Face",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    int rand1 = rollDice(Integer.parseInt(nb_face));
                    affichage_de.setText(Integer.toString(rand1));

                    int rand2 = rollDice(Integer.parseInt(nb_face));
                    deuxieme_de.setText(Integer.toString(rand2));
                }



            }
        });
    }

    private int rollDice(int nombre_face){
        return (int)(nombre_face * Math.random()) + 1;
    }
}