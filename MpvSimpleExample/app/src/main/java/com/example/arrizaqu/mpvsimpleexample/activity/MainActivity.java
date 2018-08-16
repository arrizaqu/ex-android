package com.example.arrizaqu.mpvsimpleexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.arrizaqu.mpvsimpleexample.R;
import com.example.arrizaqu.mpvsimpleexample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView{

    TextView usernameText, emailText;
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        usernameText = (TextView) findViewById(R.id.usernameText);
        emailText = (TextView) findViewById(R.id.emailText);
        Bundle bundle = getIntent().getExtras();
        presenter = new MainPresenter(this);
        presenter.setUserNameAndEmail(bundle);
    }

    @Override
    public void showUserInfo(String username, String email) {
        this.usernameText.setText(username);
        this.emailText.setText(email);
    }
}
