package com.home.presentationdemo.activity;

import android.os.Bundle;

import com.home.presentationdemo.R;
import com.home.presentationdemo.presenter.CreateAccountCompletionPresenter;
import com.home.presentationdemo.viewproxy.CreateAccountCompletionViewProxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CreateAccountCompletionActivity
        extends BaseActivity<CreateAccountCompletionPresenter, CreateAccountCompletionViewProxy> {

    @Override
    public int getContentView() {
        return R.layout.activity_create_account_completion;
    }

    @NonNull
    @Override
    public Class<CreateAccountCompletionPresenter> getPresenterClass() {
        return CreateAccountCompletionPresenter.class;
    }

    @NonNull
    @Override
    public CreateAccountCompletionViewProxy newViewProxy(@NonNull CreateAccountCompletionPresenter presenter,
                                                         @Nullable Bundle savedInstanceState) {
        return new CreateAccountCompletionViewProxy(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_in, R.anim.slide_out_from_left);
    }
}
