package com.home.presentationdemo.activity;

import android.os.Bundle;
import android.view.View;

import com.home.presentationdemo.presenter.BasePresenter;
import com.home.presentationdemo.presenter.PresenterOwner;
import com.skocken.presentation.definition.Base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter, V extends Base.IView>
        extends AppCompatActivity
        implements com.home.presentationdemo.presenter.PresenterOwner.Provider<P, V> {

    com.home.presentationdemo.presenter.PresenterOwner<P, V> mPresenterOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility( // 設置狀態欄文字顏色及圖標為深色
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (mPresenterOwner == null) mPresenterOwner = new PresenterOwner<>(this);
        onCreateDelegate(savedInstanceState);
    }

    @Nullable
    public P getPresenter() {
        return mPresenterOwner.getPresenter();
    }

    protected void onPresenterSetup(@NonNull P presenter) {
    }

    void onCreateDelegate(Bundle savedInstanceState) {
        setContentView(getContentView());
        mPresenterOwner.createPresenter();
        mPresenterOwner.initViewProxy(savedInstanceState);
        onPresenterSetup(mPresenterOwner.getPresenter());
    }
}
