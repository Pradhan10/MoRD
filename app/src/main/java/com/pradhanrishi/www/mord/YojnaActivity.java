package com.pradhanrishi.www.mord;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Custom imports


public class YojnaActivity extends AppCompatActivity  {

    private TextView mYojnaDesc;
    private Button mOpenWebsite;
    private Button mShowStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yojna);

        mYojnaDesc = (TextView)findViewById(R.id.yojnaDesc);
        mOpenWebsite = (Button)findViewById(R.id.openWebsite);
        mShowStats = (Button)findViewById(R.id.showStats);
        //mYojnaDesc.setText(R.string.DDUGKY);

        //Catching the intent which started activity and finding yojna id.
        Intent intent = getIntent();
        String id = intent.getStringExtra("mYojnaId");
        Integer intId = Integer.parseInt(id);

        /**
         * Calling mediaStore action on button
         */

        mOpenWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ddugky.gov.in/"));
                startActivity(browserIntent);
            }
        });

        mShowStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pie = new Intent(YojnaActivity.this,PieChartActivity.class);
                startActivity(pie);

            }
        });

        switch(intId){

            case 1 : mYojnaDesc.setText(R.string.DDUGKY);
                     break;

        }

    }

}
