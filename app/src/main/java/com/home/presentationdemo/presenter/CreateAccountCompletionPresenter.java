package com.home.presentationdemo.presenter;

import android.app.Activity;
import android.os.Bundle;

import com.home.presentationdemo.R;
import com.home.presentationdemo.definition.CreateAccountCompletionDefinition;
import com.home.presentationdemo.provider.CreateAccountCompletionDataProvider;

import java.util.Objects;

public class CreateAccountCompletionPresenter
        extends BasePresenter<CreateAccountCompletionDefinition.IDataProvider,
        CreateAccountCompletionDefinition.IView>
        implements CreateAccountCompletionDefinition.IPresenter {

    public CreateAccountCompletionPresenter() {
        super();
        setProvider(new CreateAccountCompletionDataProvider());
    }

    @Override
    protected void onCreateView() {
        super.onCreateView();
        String name = getProvider().getName();
        Activity activity = getActivity();
        if (activity != null) {
            Bundle bundle = activity.getIntent().getExtras();
            String phone = Objects.requireNonNull(bundle).getString("phone");
            getView().setNameAndPhone(name, phone);
        }
        getView().initializeServiceTerms();
    }

    @Override
    public void finish() {
        Objects.requireNonNull(getActivity()).finish();
        getActivity().overridePendingTransition(R.anim.zoom_in, R.anim.slide_out_from_left);
    }
}
