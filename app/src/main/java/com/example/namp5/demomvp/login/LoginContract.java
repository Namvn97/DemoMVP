package com.example.namp5.demomvp.login;

/**
 * Created by namp5 on 12/24/2018.
 */

public interface LoginContract {
    interface View {
        void onLoginSucess();

        void onLoginFaile();
    }

    interface Presenter {
        void handleLogin(String username, String password);
    }
}
