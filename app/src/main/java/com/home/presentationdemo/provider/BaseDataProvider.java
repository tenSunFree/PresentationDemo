package com.home.presentationdemo.provider;

import android.content.SharedPreferences;

import com.skocken.presentation.definition.Base;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

public abstract class BaseDataProvider<P extends Base.IPresenter> implements Base.IDataProvider {

    private P mPresenter;

    @Override
    public void setPresenter(@Nullable Base.IPresenter presenter) {
        if (mPresenter == presenter) {
            return;
        }
        //noinspection unchecked
        mPresenter = (P) presenter;
        onPresenterChanged();
    }

    /**
     * Get the Presenter previously provided.
     * <p>
     * Note: this method is marked as @NonNull, so if you did not provide any presenter before this
     * will crash right away in Kotlin, or later in your code in Java.
     * To be safer, you should either check the current status with {@link #isPresenterAttached()}
     * or use the @Nullable method {@link #getPresenterOrNull()}.
     *
     * @return the presenter previously provided.
     */
    @NonNull
    private P getPresenter() {
        return mPresenter;
    }

    /**
     * Get the Presenter if previously provided.
     *
     * @return the presenter previously provided or null if not set
     */
    @Nullable
    private P getPresenterOrNull() {
        return mPresenter;
    }

    /**
     * @return true if a Presenter has been previously set
     */
    private boolean isPresenterAttached() {
        return mPresenter != null;
    }

    /**
     * Called whenever the Presenter has been changed
     */
    private void onPresenterChanged() {
        // nothing by default
    }

    SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull(getPresenter().getContext()));
    }
}
