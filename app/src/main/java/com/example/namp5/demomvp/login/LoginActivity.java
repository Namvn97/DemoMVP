package com.example.namp5.demomvp.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.namp5.demomvp.R;
import com.example.namp5.demomvp.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,
        LoginContract.View {
    private EditText mUserNameLogin;
    private EditText mPasswordLogin;
    private Button mButtonLogin;
    private Button mButtonSignUp;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initPresenter();
    }

    public void initPresenter() {
        mPresenter = new LoginPresenter();
        mPresenter.setView(this);
    }

    public void initView() {
        mUserNameLogin = findViewById(R.id.edit_user_name);
        mPasswordLogin = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);
        mButtonSignUp = findViewById(R.id.button_signup);
        mButtonLogin.setOnClickListener(this);
        mButtonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                String username = mUserNameLogin.getText().toString();
                String password = mPasswordLogin.getText().toString();
                mPresenter.handleLogin(username, password);
                break;
            case R.id.button_signup:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            default:
                break;
        }
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
