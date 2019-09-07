package com.home.presentationdemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.home.presentationdemo.R;
import com.home.presentationdemo.presenter.CreateAccountPresenter;
import com.home.presentationdemo.viewproxy.CreateAccountViewProxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CreateAccountActivity
        extends BaseActivity<CreateAccountPresenter, CreateAccountViewProxy> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_create_account;
    }

    @NonNull
    @Override
    public Class<CreateAccountPresenter> getPresenterClass() {
        return CreateAccountPresenter.class;
    }

    @NonNull
    @Override
    public CreateAccountViewProxy newViewProxy(@NonNull CreateAccountPresenter presenter,
                                               @Nullable Bundle savedInstanceState) {
        return new CreateAccountViewProxy(this);
    }
}
