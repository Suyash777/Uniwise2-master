package com.example.uniwise;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
    Button newAcc;
    EditText email,password;
    Button submit,forgotPass,google;
    FirebaseAuth mAuth;
    FirebaseUser user;
    private GoogleSignInClient googleSignInClient;
    private String TAG="Google Sign in";
    private int RC_SIGN_IN=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newAcc=findViewById(R.id.newAccount);
        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        mAuth= FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        submit=findViewById(R.id.LoginBtn);
        email=findViewById(R.id.LemailTxt);
        password=findViewById(R.id.LPasswordTxt);
        forgotPass=findViewById(R.id.ForgotPassBtn);
        google=findViewById(R.id.LGoogle);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient= GoogleSignIn.getClient(this,gso);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fusnm;
                Fusnm=email.getText().toString();
                sendForgotPassLink(Fusnm);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Lusnm,Lpass;
                Lusnm=email.getText().toString();
                Lpass=password.getText().toString();
                Login(Lusnm,Lpass);
            }
        });
    }
    private void SignIn()
    {
        Intent SignInIntent=googleSignInClient.getSignInIntent();
        startActivityForResult(SignInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult( Task<GoogleSignInAccount> completedTask){
        try {
            GoogleSignInAccount account=completedTask.getResult(ApiException.class);
            Intent i=new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(i);
            finish();
            Toast.makeText(getApplicationContext(),"Login Successful.....",Toast.LENGTH_LONG).show();
            FirebaseGoogleAuth(account);

        } catch (ApiException e) {
            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
            FirebaseGoogleAuth(null);
        }

    }
    private void FirebaseGoogleAuth(GoogleSignInAccount account){
        AuthCredential authCredential= GoogleAuthProvider.getCredential(account.getIdToken(),null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
                    FirebaseUser user=mAuth.getCurrentUser();
                    updateUI(user);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                    updateUI(null);
                }
            }
        });
    }
    private void updateUI(FirebaseUser fuser){
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account!=null){
            String personName=account.getDisplayName();
            String personGivenName=account.getGivenName();
            String pfamilyname=account.getFamilyName();
            String personEmail=account.getEmail();
            Toast.makeText(getApplicationContext(),personName+personGivenName ,Toast.LENGTH_LONG).show();

        }
    }

    public void Login(String Lusnm,String Lpass)
    {
        mAuth.signInWithEmailAndPassword(Lusnm,Lpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.e("testexp",task.getResult().toString());
                if(task.isSuccessful()) {
                    if (mAuth.getCurrentUser().isEmailVerified()) {
                        Toast.makeText(getApplicationContext(), "Login Successful.....", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Verify email....." + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void sendForgotPassLink(String emailId){
        if(!TextUtils.isEmpty(emailId)){
            mAuth.sendPasswordResetEmail(emailId).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(),"Reset link sent to"+email.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_LONG).show();
        }
    }

}



