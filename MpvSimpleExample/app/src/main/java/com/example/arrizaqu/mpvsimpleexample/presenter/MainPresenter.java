package com.example.arrizaqu.mpvsimpleexample.presenter;

import android.os.Bundle;

public class MainPresenter {

    MainView view;

    public MainPresenter(MainView view){
        this.view = view;
    }

    public void setUserNameAndEmail(Bundle bundle){
        this.view.showUserInfo(bundle.getString("username").toString(), bundle.getString("email").toString());
    }

    public interface MainView{
        public void showUserInfo(String username, String email);
    }
}
