package com.home.presentationdemo.provider;

import com.home.presentationdemo.definition.CreateAccountCompletionDefinition;

public class CreateAccountCompletionDataProvider
        extends BaseDataProvider<CreateAccountCompletionDefinition.IPresenter>
        implements CreateAccountCompletionDefinition.IDataProvider {

    private static final String SHARED_PREFERENCES_PHONE = "shared_preferences_phone";

    @Override
    public String getName() {
        return getSharedPreferences().getString(SHARED_PREFERENCES_PHONE, null);
    }
}
