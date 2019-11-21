package com.example.dam222.mpaudiouxiaapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private MediaPlayer mediaplayer;
    //private VideoView video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Inicializar el media player
        mediaplayer = MediaPlayer.create(this, R.raw.audio);
        //mediaplayer.start();
        //Inicializamos la clase VideoView asociandole el fichero de Video

        //video=(VideoView) findViewById(R.id.videoView);
        //String path = "android.resource://" + getPackageName() + "/" + R.raw.mulan;
        //video.setVideoURI(Uri.parse(path));

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
                //video.start();
                break;
            case R.id.buttonPause:
                //Pausamos el audio
                mediaplayer.pause();
                //video.pause();
                break;
            case R.id.buttonStop:
                //Paramos el audio y volvemos a inicializar
                try {
                    mediaplayer.stop();
                    mediaplayer.prepare();
                   mediaplayer.seekTo(0);
                   //video.pause();
                    //video.seekTo(0);
                } catch (Exception e) {
                    e.printStackTrace();


                }

                break;

        }
    }//fin on click



}





