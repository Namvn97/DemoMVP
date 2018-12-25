package com.example.namp5.demomvp.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.namp5.demomvp.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,
        SignUpContract.View {
    private TextView mTextTitle;
    private EditText mUserNameSignUp;
    private EditText mPasswordSignUp;
    private EditText mConfirmPassword;
    private Button mButtonSignUp;
    private SignUpPresenter mPresenterSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
    }

    private void initView() {
        mTextTitle = findViewById(R.id.text_title_login);
        mUserNameSignUp = findViewById(R.id.edit_text_new_user);
        mPasswordSignUp = findViewById(R.id.edit_text_new_password);
        mConfirmPassword = findViewById(R.id.edit_text_confirm_password);
        mButtonSignUp = findViewById(R.id.button_sign_up);
        mButtonSignUp.setOnClickListener(this);
        mPresenterSignUp = new SignUpPresenter();
        mPresenterSignUp.setView(this);
    }

    @Override
    public void onClick(View v) {
        String username = mUserNameSignUp.getText().toString();
        String password = mPasswordSignUp.getText().toString();
        String confirm = mConfirmPassword.getText().toString();
        mPresenterSignUp.handleSignUp(username, password, confirm);
    }

    @Override
    public void onSignUpSucess(String sucess) {
        Toast.makeText(this, sucess, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpFaile(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
