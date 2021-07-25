package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.model.User;
/**
 * https://www.youtube.com/watch?v=lQChsNFeAMc tutorial used for Google sign in for the application
 * Displays google account information after user is successfully logged in to Google account.
 * @author Group 4 : Macro Grocery Guide App
 */
public class Login2Activity extends AppCompatActivity {
    //view items
    GoogleSignInClient mGoogleSignInClient;
    Button sign_out;
    TextView nameTV;
    TextView emailTV;
    TextView idTV;
    ImageView photoIV;
    Button assessment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        //locate view items
        sign_out = findViewById(R.id.log_out);
        nameTV = findViewById(R.id.name);
        emailTV = findViewById(R.id.email);
        idTV = findViewById(R.id.id);
        photoIV = findViewById(R.id.photo);
        assessment = findViewById(R.id.assessmentButton);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Login2Activity.this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            //create instance of User using Google account information
            User.getInstance().createUser(personName, personEmail);

            nameTV.setText("Name: "+personName);
            emailTV.setText("Email: "+personEmail);
            idTV.setText("ID: "+personId);
            Glide.with(this).load(personPhoto).into(photoIV);
        }
        //capture assessment button clicks - start new activity
        assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login2Activity.this, BodyInformationActivity.class));
            }
        });
        //capture sign_out button clicks - go back to login screen
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Login2Activity.this,"Successfully signed out",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login2Activity.this, LoginActivity.class));
                        finish();
                    }
                });
    }
}