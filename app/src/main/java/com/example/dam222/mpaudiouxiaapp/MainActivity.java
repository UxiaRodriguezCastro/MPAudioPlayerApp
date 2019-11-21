package com.example.dam222.mpaudiouxiaapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private MediaPlayer mediaplayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Inicializar el media player
        mediaplayer = MediaPlayer.create(this, R.raw.audio);
       // mediaPlayer.start();

        //Obtenemos los tres botones de la interfaz
        btnPlay= (Button)findViewById(R.id.buttonPlay);
        btnStop= (Button)findViewById(R.id.buttonStop);
        btnPause= (Button)findViewById(R.id.buttonPause);
        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);

    }//fin on create


    @Override
    public void onClick(View v) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(v.getId()){
            case R.id.buttonPlay:
                //Iniciamos el audio
                mediaplayer.start();
                break;
            case R.id.buttonPause:
                //Pausamos el audio
                mediaplayer.pause();
                break;
            case R.id.buttonStop:
                //Paramos el audio y volvemos a inicializar
                try {
                    mediaplayer.stop();
                    mediaplayer.prepare();
                    mediaplayer.seekTo(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;

        }
    }//fin on click
}





