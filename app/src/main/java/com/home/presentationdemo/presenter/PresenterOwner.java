package com.home.presentationdemo.presenter;

import android.os.Bundle;

import com.skocken.presentation.definition.Base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class PresenterOwner<P extends com.home.presentationdemo.presenter.BasePresenter,
        V extends Base.IView> {

    private final ViewModelProvider mViewModelProvider;
    private final PresenterOwner.Provider<P, V> mProvider;

    private P mPresenter;

    public <A extends AppCompatActivity & PresenterOwner.Provider<P, V>> PresenterOwner(@NonNull A provider) {
        this(ViewModelProviders.of(provider), provider);
    }

    public <F extends Fragment & PresenterOwner.Provider<P, V>> PresenterOwner(@NonNull F provider) {
        this(ViewModelProviders.of(provider), provider);
    }

    private PresenterOwner(@NonNull ViewModelProvider viewModelProvider,
                           @NonNull PresenterOwner.Provider<P, V> provider) {
        mViewModelProvider = viewModelProvider;
        mProvider = provider;
    }

    public P getPresenter() {
        return mPresenter;
    }

    public void createPresenter() {
        mPresenter = mViewModelProvider.get(mProvider.getPresenterClass());
    }

    public void initViewProxy(Bundle savedInstanceState) {
        V viewProxy = mProvider.newViewProxy(mPresenter, savedInstanceState);
        mPresenter.setView(viewProxy);
    }

    public interface Provider<P extends BasePresenter, V extends Base.IView> {
        int getContentView();

        @NonNull
        Class<P> getPresenterClass();

        @NonNull
        V newViewProxy(@NonNull P presenter, @Nullable Bundle savedInstanceState);
    }
}
