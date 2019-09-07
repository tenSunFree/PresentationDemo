package com.home.presentationdemo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.home.presentationdemo.R;
import com.home.presentationdemo.activity.CreateAccountCompletionActivity;
import com.home.presentationdemo.definition.CreateAccountDefinition;
import com.home.presentationdemo.provider.CreateAccountDataProvider;

public class CreateAccountPresenter
        extends BasePresenter<CreateAccountDefinition.IDataProvider, CreateAccountDefinition.IView>
        implements CreateAccountDefinition.IPresenter {

    public CreateAccountPresenter() {
        super();
        setProvider(new CreateAccountDataProvider());
    }

    @Override
    public void onClickNextStepButton(String name, String phone) {
        Activity activity = getActivity();
        if (activity != null) {
            getProvider().saveName(name);
            Bundle bundle = new Bundle(); // new一個Bundle物件, 並將要傳遞的資料傳入
            bundle.putString("phone", phone);
            Intent intent = new Intent(activity, CreateAccountCompletionActivity.class);
            intent.putExtras(bundle); // 將Bundle物件assign給intent
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.zoom_out);
        }
    }
}
