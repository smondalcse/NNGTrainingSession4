package com.nitolniloygroup.nngtrainingsession;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TextView txtResult;
    EditText et_empid, et_password;
    Button btnLogin;
    RadioGroup radioGroup;
    RadioButton rb1, rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar toolsbar = getSupportActionBar();
        toolsbar.setTitle("Login");
        toolsbar.hide();

        et_empid = findViewById(R.id.et_empid);
        et_password = findViewById(R.id.et_password);

        radioGroup = findViewById(R.id.rg);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);


        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedID = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedGender = (RadioButton) findViewById(selectedID);
                Log.i(TAG, "onClick: " + selectedGender.getText());

                String input_empID = et_empid.getText().toString();
                String input_password = et_password.getText().toString();

                if(input_empID.equalsIgnoreCase("123") && input_password.equalsIgnoreCase("321")){

                    UserModel user1 = new UserModel();
                    user1.setEmpID(input_empID);
                    user1.setEmpName("Nitol Niloy Group");
                    user1.setEmpMobile("547896541");

                    UserModel user2 = new UserModel();
                    user2.setEmpID("502");
                    user2.setEmpName("Nitol Niloy Group-502");
                    user2.setEmpMobile("502502");

                    UserModel user3 = new UserModel();
                    user3.setEmpID("503");
                    user3.setEmpName("Nitol Niloy Group - 503");
                    user3.setEmpMobile("502503");

                    UserModel user4 = new UserModel();
                    user4.setEmpID("504");
                    user4.setEmpName("Nitol Niloy Group - 504");
                    user4.setEmpMobile("502504");

//                    ArrayList<UserModel> users = new ArrayList<>();
//                    users.add(user1);
//                    users.add(user2);
//                    users.add(user3);
//                    users.add(user4);

                    List<UserModel> listUsers = new ArrayList<>();
                    listUsers.add(user1);
                    listUsers.add(user2);
                    listUsers.add(user3);
                    listUsers.add(user4);

                    UsersModel objUsers = new UsersModel();
                    objUsers.setUsers(listUsers);

                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
//                    intent.putExtra("empid", input_empID);
//                    intent.putExtra("name", "Sanat Mondal");
//                    intent.putExtra("mobile", 1712995265);

                    intent.putExtra("users", objUsers);

                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid EmpID or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView imgLogo = findViewById(R.id.imgLogo);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgLogo.setImageResource(R.drawable.logo1);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("nng training sesison", "on start: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("nng training sesison", "on resume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("nng training sesison", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("nng training sesison", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("nng training sesison", "onDestroy: ");
    }


}