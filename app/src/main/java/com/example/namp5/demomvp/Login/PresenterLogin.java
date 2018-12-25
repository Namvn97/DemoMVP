package com.example.namp5.demomvp.Login;

/**
 * Created by namp5 on 12/19/2018.
 */

public class PresenterLogin implements LoginContract.Presenter {
    private LoginContract.View mView;

    public void setView(LoginContract.View view){
        this.mView = view;
    }

    @Override
    public void handleLogin(String username, String password) {
        if ("phannam".equals(username) && "phannam123".equals(password)) {
            mView.onLoginSucess();
            return;
        } else {
            mView.onLoginFaile();
        }
    }
}
