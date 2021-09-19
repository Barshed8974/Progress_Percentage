package com.example.thread_ii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {
    private CircularProgressIndicator progressbar;
    private TextView tv1;
    private Handler mainThreadHandler=new Handler(Looper.getMainLooper())
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    int progress=(int) msg.obj;
                    progressbar.setProgress(progress);
                    tv1.setText(progress+"");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbar=findViewById(R.id.progressBar);
        tv1=findViewById(R.id.tv1);
        WorkerThread workerThread=new WorkerThread("Ali",mainThreadHandler);
        workerThread.start();
    }
}