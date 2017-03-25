package com.pradhanrishi.www.mord;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pradhanrishi.www.mord.Activiity_login;


/**
 * Created by yash on 25/3/17.
 */

public class Activity_home extends AppCompatActivity{

    private Activity mLoginActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mLoginActivity = (Activity) getClass(Activiity_login.);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater myInflater = getMenuInflater();
        myInflater.inflate(R.menu.activity_home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            switch(item.getItemId()){
                case R.id.action_Sign_out:
                    Activiity_login myLogin = new Activiity_login();
                    myLogin.signOut();
            }
        return super.onOptionsItemSelected(item);
    }
}
