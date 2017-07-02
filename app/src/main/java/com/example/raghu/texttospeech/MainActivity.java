package com.example.raghu.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech ts;
    ImageButton b;
    EditText et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(ImageButton) findViewById(R.id.imageButton);
        et=(EditText)findViewById(R.id.editText);
        ts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    ts.setLanguage(Locale.UK);
                }

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String speak=et.getText().toString();

                ts.speak(speak,TextToSpeech.QUEUE_FLUSH,null);


            }
        });

   }


    public void onPause(){
        if(ts !=null){
            ts.stop();
            ts.shutdown();
        }
        super.onPause();
    }
}
