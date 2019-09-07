package com.home.presentationdemo.definition;

import com.skocken.presentation.definition.Base;

public interface CreateAccountDefinition {

    interface IPresenter extends Base.IPresenter {

        void onClickNextStepButton(String name, String phone);
    }

    interface IDataProvider extends Base.IDataProvider {

        void saveName(String name);
    }

    interface IView extends Base.IView {
    }
}
