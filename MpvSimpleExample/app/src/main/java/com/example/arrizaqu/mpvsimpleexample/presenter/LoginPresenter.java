package com.example.arrizaqu.mpvsimpleexample.presenter;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.arrizaqu.mpvsimpleexample.entity.User;

public class LoginPresenter {

    View view;

    public LoginPresenter(View view){
        this.view = view;
    }

    public void checkUsernameAndEmail(String username, String email){
        boolean login = true;
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("email", email);

        if(login == true)
            this.view.loginSuccess(bundle);
        else
            this.view.loginFailed();
    }

    public interface View{
        void loginSuccess(Bundle bundle);
        void loginFailed();
    }
}
