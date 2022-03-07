package com.nitolniloygroup.nngtrainingsession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ActionBar toolsbar = getSupportActionBar();
        toolsbar.setTitle("Dashboard");
        toolsbar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
//        String empID = bundle.getString("empid", "No Employee ID found");
//        String name = bundle.getString("name", "No Employee name found");
//        int mobile = bundle.getInt("mobile", 0);

       // UserModel user = (UserModel) bundle.getSerializable("user");

        UsersModel usersModel = (UsersModel) bundle.getSerializable("users");

        List<UserModel> listUsers = usersModel.getUsers();

        UserModel u1 = listUsers.get(0);
        UserModel u2 = listUsers.get(1);
        UserModel u3 = listUsers.get(2);
        UserModel u4 = listUsers.get(3);

        TextView txtEmpID = findViewById(R.id.txtEmpID);
        txtEmpID.setText(u3.getEmpID());

        TextView txtName = findViewById(R.id.txtName);
        txtName.setText(u3.getEmpName());

        TextView txtMobile = findViewById(R.id.txtMobile);
        txtMobile.setText(String.valueOf(u3.getEmpMobile()));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}