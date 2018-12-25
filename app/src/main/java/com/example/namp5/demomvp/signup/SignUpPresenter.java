package com.example.namp5.demomvp.signup;

import android.widget.Toast;

/**
 * Created by namp5 on 12/24/2018.
 */

public class SignUpPresenter implements SignUpContract.Presenter {
    private SignUpContract.View mView;

    public void setView(SignUpContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignUp(String username, String password, String comfirm) {
        if (username.isEmpty() || password.isEmpty() || comfirm.isEmpty()) {
            mView.onSignUpFaile("Username or Password is Empty!");
        }
        if (!password.equals(comfirm)) {
            mView.onSignUpFaile("Incorect Password");
        } else {
            mView.onSignUpSucess("Wecomel to Demo MVP");
        }
    }
}
