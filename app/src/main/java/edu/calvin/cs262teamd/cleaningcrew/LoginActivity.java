package edu.calvin.cs262teamd.cleaningcrew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Menu menu;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView invalidTextView;
    private Button loginButton;
    private boolean rightPassword;
    private boolean rightUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        invalidTextView = (TextView) findViewById(R.id.invalidTextView);
        invalidTextView.setVisibility(View.GONE);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        /* Listener waits for a click and deletes the initial text in the username editText
         * @return void
         */
        usernameEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameEditText.getText().toString().equals("Username")){
                    usernameEditText.setText("");
                }
            }
        });
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        /* Listener waits for a click and deletes the initial text in the password editText
         * @return void
         */
        passwordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordEditText.getText().toString().equals("example")){
                    passwordEditText.setText("");
                }
            }
        });
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (username.equals("user")) {
                    if (password.equals("password")){
                        invalidTextView.setVisibility(View.VISIBLE);
                        invalidTextView.setText("Welcome, User");
                        MenuItem item = menu.findItem(R.id.main_page);
                        switch (item.getItemId()) {
                            case R.id.main_page:
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            default:
                        }
                    }
                } else {
                    invalidTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    // Initilizes the menu for the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        this.menu = menu;
        return true;
    }
}
