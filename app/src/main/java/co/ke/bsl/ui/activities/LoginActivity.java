package co.ke.bsl.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import co.ke.bsl.R;

public class LoginActivity extends AppCompatActivity {
Button signInButton;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButton= (Button) findViewById(R.id.loginButton) ;
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
                if(validateEmail()) {
                    validatepassword();
                }
                if(validateEmail() &&  validatepassword()){
                    dialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            // Actions to do after 5 seconds
                            Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                            startActivity(i);
                        }
                    }, 5000);


                    //finish();

                }

            }
        });

    }

    private boolean validateEmail() {

        EditText editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        String mail=editTextEmail.getText().toString().trim();
        if (mail.length() < 4 ) {
            editTextEmail.setError("Email Must consist of at least 4 characters");
            return false;
        } else if (!mail.matches("^[A-za-z0-9.@]+")) {
            editTextEmail.setError("Only . and @ characters allowed");
            return false;
        } else if (!mail.contains("@")) {
            editTextEmail.setError("Email must contain @");
            return false;
        } else if (!mail.contains(".")) {
            editTextEmail.setError("Email must contain .");
            return false;
        }
        return true;
    }
    private boolean validatepassword() {

        EditText editTextpassword=(EditText) findViewById(R.id.editTextPassword);
        String pass=editTextpassword.getText().toString().trim();
        if (pass.length()==0 ) {
            editTextpassword.setError("password cannot be blank");
            return false;
        }
        return true;
    }


public void dialog(){
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMax(100);
                progressDialog.setMessage("Authenticating");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (progressDialog.getProgress() <= progressDialog.getMax()) {
                   Thread.sleep(10000);
                    //handle.sendMessage(handle.obtainMessage());
                    //if (progressDialog.getProgress() == progressDialog.getMax()) {
                        progressDialog.dismiss();
                   // }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
}

    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.incrementProgressBy(1);
        }
    };
}


