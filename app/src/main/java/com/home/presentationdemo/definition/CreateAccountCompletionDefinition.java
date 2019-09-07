package com.home.presentationdemo.definition;

import com.skocken.presentation.definition.Base;

public interface CreateAccountCompletionDefinition {

    interface IPresenter extends Base.IPresenter {

        void finish();
    }

    interface IDataProvider extends Base.IDataProvider {

        String getName();
    }

    interface IView extends Base.IView {

        void setNameAndPhone(String name, String phone);

        void initializeServiceTerms();
    }
}
