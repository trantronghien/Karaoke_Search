package com.example.admin.karaokesearch.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.karaokesearch.R;
import com.example.admin.karaokesearch.models.api.App;
import com.example.admin.karaokesearch.models.api.DatabaseOpenHelper;
import com.example.admin.karaokesearch.ui.customUI.CustomProgressDialog;
import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.FadingCircle;

public class WelcomeActivity extends AppCompatActivity {

    private final int WELCOME_TIME_OUT = 3000;
    // https://github.com/ybq/Android-SpinKit
    Context context ;
    SpinKitView spinKitView;
    TextView txtMes;
    private void inIt(){
        context = WelcomeActivity.this;
        spinKitView = (SpinKitView) findViewById(R.id.progress);
        txtMes = (TextView) findViewById(R.id.txt_welcome_mes);

//      progressDialog.setIndeterminateDrawable(new FadingCircle());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        inIt();
        DatabaseOpenHelper openHelper = new DatabaseOpenHelper(App.getContext(), DatabaseOpenHelper.DATASE_NAME , null);
        Handler handler = new Handler();

//        openHelper.setOnCopyDatabaseFinished(new DatabaseOpenHelper.onCopyDatabaseFinished() {
//            @Override
//            public void onCopyFinished(boolean isFinished) {
//                if (isFinished){
//                    spinKitView.setVisibility(View.INVISIBLE);
//                }
//            }
//        });
//
//        openHelper.processCopy();

        if(openHelper.databaseExists()){
            txtMes.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this , MainActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    finish();
                }
            }, WELCOME_TIME_OUT);
        }else {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this , MainActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    finish();
                }
            }, WELCOME_TIME_OUT);
        }

    }


}
