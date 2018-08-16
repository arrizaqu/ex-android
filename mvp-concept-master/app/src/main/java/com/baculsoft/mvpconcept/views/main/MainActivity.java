package com.baculsoft.mvpconcept.views.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.baculsoft.mvpconcept.R;
import com.baculsoft.mvpconcept.internal.model.Data;
import com.baculsoft.mvpconcept.views.result.ResultFragment;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainActivity extends AppCompatActivity implements MainView {
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter();
        //onAttachView();
        presenter.onAttach(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
        //addButtonListener();
        final Button button = (Button) findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                button.setVisibility(View.GONE);
                presenter.showFragment();
            }
        });
    }

    @Override
    public void onAttachView() {

    }


    @Override
    public void onShowFragment(final Data data) {
        // Get Data
        final Bundle bundle = new Bundle();
        bundle.putString("data", data.getText());

        // Show Fragment with Data
        final String tag = ResultFragment.class.getSimpleName();
        Log.d("pop", tag);
        final Fragment fragment = ResultFragment.newInstance();
        fragment.setArguments(bundle);

        // Begin Fragment Transaction
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

}