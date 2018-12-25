package com.example.namp5.demomvp.signup;

/**
 * Created by namp5 on 12/24/2018.
 */

public interface SignUpContract {
    interface View {
        void onSignUpSucess(String sucess);

        void onSignUpFaile(String error);
    }

    interface Presenter {
        void handleSignUp(String username, String password, String comfirm);
    }
}
