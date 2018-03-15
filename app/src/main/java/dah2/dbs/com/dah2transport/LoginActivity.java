package dah2.dbs.com.dah2transport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Prateek on 10-03-2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText username;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initFields();
    }

    private void initFields() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        //dummy Values
        username.setText("prateekm");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                if(username.getText().toString().equals("prateekm") && password.getText().toString().equals("prateekm")) {
                    Intent mIntent = new Intent(this, MainActivity.class);
                    Bundle mBundle = new Bundle();
                    mBundle.putString("login", "success");
                    mIntent.putExtras(mBundle);
                    startActivity(mIntent);
                } else {
                    makeToast(this, "Invalid Credentials");
                }
                break;
        }
    }

    private void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG);
    }
}
