package com.home.presentationdemo.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

import com.skocken.presentation.definition.Base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

public abstract class BasePresenter<D extends Base.IDataProvider, V extends Base.IView>
        extends ViewModel
        implements Base.IPresenter {

    private D mProvider;
    private V mView;

    BasePresenter() {
    }

    void setProvider(@Nullable Base.IDataProvider provider) {
        if (mProvider == provider) {
            return; // no changes
        }
        //noinspection unchecked
        mProvider = (D) provider;
        if (mProvider != null) {
            mProvider.setPresenter(this);
        }
        onProviderChanged();
        onViewOrProviderChanged();
    }

    @Override
    public void setView(@Nullable Base.IView view) {
        if (mView == view) {
            return; // no changes
        }
        //noinspection unchecked
        mView = (V) view;
        if (mView != null) {
            mView.setPresenter(this);
        }
        onCreateView();
        onViewOrProviderChanged();
    }

    @Nullable
    @Override
    public Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            // get the base activity and loop.
            // fix to get Activity from android.support.v7.app.MediaRouteButton#getActivity()
            Context previousContext = context;
            context = ((ContextWrapper) context).getBaseContext();
            if (previousContext.equals(context)) {
                break; // no more base context, stack overflow possible, leave the while
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Context getContext() {
        if (mView == null) {
            return null;
        } else {
            return mView.getContext();
        }
    }

    @Nullable
    @Override
    public Resources getResources() {
        if (mView == null) {
            return null;
        } else {
            return mView.getResources();
        }
    }

    /**
     * Get the Provider previously provided.
     * <p>
     * Note: this method is marked as @NonNull, so if you did not provide any provider before this
     * will crash right away in Kotlin, or later in your code in Java.
     * To be safer, you should either check the current status with {@link #isProviderAttached()}
     * or use the @Nullable method {@link #getProviderOrNull()}.
     *
     * @return the provider previously provided.
     */
    @NonNull
    D getProvider() {
        return mProvider;
    }

    /**
     * Get the Provider if previously provided.
     *
     * @return the provider previously provided or null if not set
     */
    @Nullable
    private D getProviderOrNull() {
        return mProvider;
    }

    /**
     * @return true if a Provider has been previously set
     */
    private boolean isProviderAttached() {
        return mProvider != null;
    }

    /**
     * Get the View previously provided.
     * <p>
     * Note: this method is marked as @NonNull, so if you did not provide any provider before this
     * will crash right away in Kotlin, or later in your code in Java.
     * To be safer, you should either check the current status with {@link #isViewAttached()}
     * or use the @Nullable method {@link #getViewOrNull()}.
     *
     * @return the view previously provided.
     */
    @NonNull
    V getView() {
        return mView;
    }

    /**
     * Get the View if previously provided.
     *
     * @return the view previously provided or null if not set
     */
    @Nullable
    private V getViewOrNull() {
        return mView;
    }

    /**
     * @return true if a View has been previously set
     */
    private boolean isViewAttached() {
        return mView != null;
    }

    protected void onCreateView() {
        // nothing by default
    }

    private void onProviderChanged() {
        // nothing by default
    }

    private void onViewOrProviderChanged() {
        // nothing by default
    }
}
