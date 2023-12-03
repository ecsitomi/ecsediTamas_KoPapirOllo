package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagePlayer;
    private ImageView imageCPU;
    private TextView eredmenyEmberPont;
    private TextView eredmenyCPUPont;
    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonScis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        imagePlayer=findViewById(R.id.imagePlayer);
        imageCPU=findViewById(R.id.imageCPU);
        buttonRock=findViewById(R.id.buttonRock);
        buttonPaper=findViewById(R.id.buttonPaper);
        buttonScis=findViewById(R.id.buttonScis);
        eredmenyEmberPont=findViewById(R.id.eredmenyEmberPont);
        eredmenyCPUPont=findViewById(R.id.eredmenyCPUPont);

    }
}