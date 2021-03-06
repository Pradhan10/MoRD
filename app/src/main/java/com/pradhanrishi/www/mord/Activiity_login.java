package com.pradhanrishi.www.mord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by yash on 24/3/17.
 */

public class Activiity_login extends MyBase implements View.OnClickListener {

    /**
     *
     * @param savedInstanceState
     * Static and final declarations here.
     */
    private static final String TAG = "Login Activity";
    private int flag =1;
    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;
    private Button mForgotPassword;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    // [START declare_auth_listener]
    private FirebaseAuth.AuthStateListener mAuthListener;
    // [END declare_auth_listener]


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.editMail);
        mPassword = (EditText) findViewById(R.id.editPassword);
        mLogin = (Button) findViewById(R.id.buttonSignin);
        mForgotPassword = (Button) findViewById(R.id.buttonForgotPassword);

        //OnClickListeners for Buttons
        mLogin.setOnClickListener(this);
        mForgotPassword.setOnClickListener(this);

        /**
         * FireBase intializations
         */
        mAuth = FirebaseAuth.getInstance();

        //start Auth state listener
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    // User is signed in
                    Log.d(TAG,"onAuthStateChanged:signed_in"+user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG,"onAuthStateChanged:signed_out");
                }
                // Start Intent here for next activity or UI update
                // TODO : To be implemented later!!!
                updateUI(user);
            }
        };
        // END auth state listener

    }

    //Start onAuthstart listener
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    // End on auth state listener


    // Stop onAuthStop listener
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null ){
            mAuth.removeAuthStateListener(mAuthListener);

        }
     // End on auth state listener

    }


    private boolean validateForm() {
        boolean valid = true;

        String email = mEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Required.");
            valid = false;
        } else {
            mEmail.setError(null);
        }

        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Required.");
            valid = false;
        } else {
            mPassword.setError(null);
        }

        return valid;
    }



    private void updateUI(FirebaseUser user) {
        flag++;
        hideProgressDialog();
        if (user != null) {

            Intent home = new Intent(Activiity_login.this,Activity_home.class);
            startActivity(home);

        } else {
            Toast.makeText(Activiity_login.this,"Sign Out",Toast.LENGTH_SHORT).show();
        }
    }



    private void signIn(String email, String password){
        Log.d(TAG,"signIn:"+email);
        if( !validateForm()) {
            return;
        }

        showProgressDialog();

        // [START Signin with Email]
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG,"signInWithEmail"+ task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(Activiity_login.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            Toast.makeText(Activiity_login.this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
                        }
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
        //// TODO: 21/3/17 yash new message.

    }

    public void signOut() {
        mAuth.signOut();
        updateUI(null);
    }



    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.buttonSignin){

            //TODO : Implement method call for action here
            signIn(mEmail.getText().toString(), mPassword.getText().toString());

        }else if(i == R.id.buttonForgotPassword){

            //TODO : Implement method call for action here


        }

    }
}
