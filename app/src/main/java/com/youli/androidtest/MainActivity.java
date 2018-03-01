package com.youli.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    Timer timer;
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

                Toast.makeText(MainActivity.this,"2222222222",Toast.LENGTH_SHORT).show();
                Log.e("2018-3-1","222222222222222222222222");

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,TwoActivity.class);
                startActivity(i);

            }
        });


      timer=new Timer(true);

       TimerTask task=new TimerTask() {
           @Override
           public void run() {

               Message msg=new Message();

               msg.what=1;

               handler.sendMessage(msg);

           }
       };

        timer.schedule(task, 0, 2000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.e("2018-3-1","3333333333333333333333");


        timer.cancel();

    }
}
