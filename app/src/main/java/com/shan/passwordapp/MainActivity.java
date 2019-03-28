package com.example.sweetlogic.password;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityPassword extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_password);

        addListenerOnButtons();
    }

    public void addListenerOnButtons() {
        Button loginButton = (Button) findViewById(R.id.buttonClickToLogin);
        Button revealPasswordButton = (Button) findViewById(R.id.buttonRevealPassword);
        final EditText username = (EditText) findViewById(R.id.editUsername);
        final EditText password = (EditText) findViewById(R.id.editPassword);


        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivityPassword.this, "Login with \nusername : " + username.getText() + "\npassword : " + password.getText(), Toast.LENGTH_SHORT).show();

            }
        });

        revealPasswordButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // some how the constant value is not 128 as listed in
                // https://developer.android.com/reference/android/text/InputType.html
                //
                // But 129 from the toast message below!
                // why? 129 instead of 128?
                // see https://stackoverflow.com/questions/9951326/basic-android-code-edittexts-inputtype-why-was-the-bitwise-operator-used

                //Toast.makeText(MainActivityPassword.this, "input type : "+password.getInputType(), Toast.LENGTH_SHORT).show();

                if (password.getInputType() == 129) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL); // reveal password in plainText
                } else if (password.getInputType() == InputType.TYPE_TEXT_VARIATION_NORMAL) {
                    password.setInputType(129); // change back to password field
                }


            }
        });


      /*  NOTE: Use this portion if testing on real Android device.
                Remember to comment out setOnClickListener

       revealPasswordButton.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View view, MotionEvent event) {
                 if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL); // reveal password in plainText
                 } else if (event.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                     password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                 }
                 return true;
             }
         });
        */


    }

}