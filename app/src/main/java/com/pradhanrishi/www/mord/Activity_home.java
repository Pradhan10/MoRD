package com.pradhanrishi.www.mord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

//Custom import


/**
 * Created by yash on 25/3/17.
 */

public class Activity_home extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mDDuGKY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.e("Activity_home:","onCreate called");
        mDDuGKY = (ImageButton) findViewById(R.id.imageButton2);
        //mLoginActivity = (Activity) getClass(Activiity_login.);

        mDDuGKY.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater myInflater = getMenuInflater();
        myInflater.inflate(R.menu.activity_home_menu,menu);
        Log.e("Activity_home:","onCreateOptionsMenu called");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            switch(item.getItemId()){
                case R.id.action_Sign_out:
                    Activiity_login myLogin = new Activiity_login();
                    //myLogin.signOut();
            }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onClick(View v) {
        int i = v.getId();
        Log.e("Activity_home:","onClick called");
        switch (i) {

            case R.id.imageButton2:
                GetYojnaId.mYojnaId = 1;
                Intent yojna = new Intent(Activity_home.this,YojnaActivity.class);
                yojna.putExtra("mYojnaId","1");
                startActivity(yojna);
                break;

        }
    }
}
