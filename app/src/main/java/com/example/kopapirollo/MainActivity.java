package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.DialogInterface;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageView imagePlayer;
    private ImageView imageCPU;
    private TextView eredmenyEmberPont;
    private TextView eredmenyCPUPont;
    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonScis;
    private AlertDialog alertDialog;
    private int emberValaszt;
    private int cpuValaszt;
    private int emberPont;
    private int cpuPont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //A játékos választ
        buttonRock.setOnClickListener(v -> {
            imagePlayer.setImageResource(R.drawable.rock);
            emberValaszt = 0;});
        buttonPaper.setOnClickListener(v -> {
            imagePlayer.setImageResource(R.drawable.paper);
            emberValaszt = 1;});
        buttonScis.setOnClickListener(v -> {
            imagePlayer.setImageResource(R.drawable.scissors);
            emberValaszt = 2;});
        cpuRandom();
        kiNyert(emberValaszt,cpuValaszt);
        gameOver(emberPont,cpuPont);
    }

    public void init(){
        imagePlayer=findViewById(R.id.imagePlayer);
        imageCPU=findViewById(R.id.imageCPU);
        buttonRock=findViewById(R.id.buttonRock);
        buttonPaper=findViewById(R.id.buttonPaper);
        buttonScis=findViewById(R.id.buttonScis);
        eredmenyEmberPont=findViewById(R.id.eredmenyEmberPont);
        eredmenyCPUPont=findViewById(R.id.eredmenyCPUPont);

        //ITT PICIT CSALTAM, KELLETT A cGPT-t HOGY BEÁLLÍTSAM JÓL AZ ÜZENETET
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnél új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newGame();
                    }
                })
                .setCancelable(false);
        alertDialog = builder.create();
    }
    public int cpuRandom() {
        Random random = new Random();
        cpuValaszt=random.nextInt(3);
        switch (cpuValaszt) {
            case 0:
                imageCPU.setImageResource(R.drawable.rock);
                break;
            case 1:
                imageCPU.setImageResource(R.drawable.paper);
                break;
            case 2:
                imageCPU.setImageResource(R.drawable.scissors);
                break;
        }
        return cpuValaszt;
    }

    public void kiNyert(int emberValaszt, int cpuValaszt){
        if (emberValaszt==cpuValaszt){
            Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
        } else if ((emberValaszt==0 && cpuValaszt==2) || (emberValaszt==1 && cpuValaszt==0) || (emberValaszt==2 && cpuValaszt==1)) {
            emberPont++;
            eredmenyEmberPont.setText(String.valueOf(emberPont));
            Toast.makeText(MainActivity.this, "Gratulálok, te nyertél!", Toast.LENGTH_SHORT).show();
        } else {
            cpuPont++;
            eredmenyCPUPont.setText(String.valueOf(cpuPont));
            Toast.makeText(MainActivity.this, "Sajnálom, a gép nyert!", Toast.LENGTH_SHORT).show();
        }
    }

    public void gameOver(int emberPont, int cpuPont) {
        if (emberPont == 3) {
            alertDialog.setTitle("Gratulálok, nyertél!");
            alertDialog.create();
            alertDialog.show();
        } if (cpuPont == 3) {
            alertDialog.setTitle("Sajnálom, vesztettél!");
            alertDialog.create();
            alertDialog.show();
        }
    }

    public void newGame(){
        imagePlayer.setImageResource(R.drawable.rock);
        imageCPU.setImageResource(R.drawable.rock);
        eredmenyCPUPont.setText("0");
        eredmenyEmberPont.setText("0");
        emberValaszt=0;
        cpuValaszt=0;
        emberPont=0;
        cpuPont=0;
    }
}