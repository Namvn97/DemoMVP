package com.example.namp5.demomvp.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.namp5.demomvp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,
        LoginContract.View {
    private EditText mUserNameLogin;
    private EditText mPasswordLogin;
    private Button mButtonLogin;
    private PresenterLogin mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
    }

    public void initPresenter(){
        mPresenter = new PresenterLogin();
        mPresenter.setView(this);
    }

    public void initView() {
        mUserNameLogin = findViewById(R.id.edit_user_name);
        mPasswordLogin = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = mUserNameLogin.getText().toString();
        String password = mPasswordLogin.getText().toString();
        mPresenter.handleLogin(username,password);
    }


    @Override
    public void onLoginSucess() {
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFaile() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }
}
