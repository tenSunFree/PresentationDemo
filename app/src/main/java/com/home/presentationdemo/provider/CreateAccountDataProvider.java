package com.home.presentationdemo.provider;

import android.content.SharedPreferences;

import com.home.presentationdemo.definition.CreateAccountDefinition;

public class CreateAccountDataProvider
        extends BaseDataProvider<CreateAccountDefinition.IPresenter>
        implements CreateAccountDefinition.IDataProvider {

    private static final String SHARED_PREFERENCES_PHONE = "shared_preferences_phone";

    @Override
    public void saveName(String value) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SHARED_PREFERENCES_PHONE, value);
        editor.apply();
    }
}
