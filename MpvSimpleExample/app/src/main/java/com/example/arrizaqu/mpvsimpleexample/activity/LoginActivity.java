package com.example.arrizaqu.mpvsimpleexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.arrizaqu.mpvsimpleexample.R;
import com.example.arrizaqu.mpvsimpleexample.presenter.LoginPresenter;


public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {

    LoginPresenter presenter;
    Button button;
    TextView inputName;
    TextView inputEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        inputName = (TextView) findViewById(R.id.inputName);
        inputEmail = (TextView) findViewById(R.id.inputEmail);
        presenter = new LoginPresenter(this);
        Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.checkUsernameAndEmail(inputName.getText().toString(), inputEmail.getText().toString());
            }
        });

    }

    @Override
    public void loginSuccess(Bundle bundle) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        super.onBackPressed();
    }
}
