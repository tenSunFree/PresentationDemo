package com.home.presentationdemo.viewproxy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.home.presentationdemo.R;
import com.home.presentationdemo.definition.CreateAccountDefinition;
import com.skocken.presentation.viewproxy.BaseViewProxy;

import java.util.Objects;

import androidx.annotation.NonNull;

public class CreateAccountViewProxy
        extends BaseViewProxy<CreateAccountDefinition.IPresenter>
        implements CreateAccountDefinition.IView, View.OnClickListener {

    public CreateAccountViewProxy(@NonNull Activity activity) {
        super(activity);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onInit() {
        super.onInit();
        Objects.requireNonNull(findViewByIdEfficient(R.id.button_next_step)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_next_step) {
            EditText nameEditText = findViewByIdEfficient(R.id.edit_text_name);
            EditText phoneEditText = findViewByIdEfficient(R.id.edit_text_phone);
            String name = Objects.requireNonNull(nameEditText).getText().toString();
            String phone = Objects.requireNonNull(phoneEditText).getText().toString();
            String empty = "";
            if (!name.equals(empty) && !phone.equals(empty)) {
                getPresenter().onClickNextStepButton(name, phone);
            } else {
                String cannotNull = "不能為空值";
                Toast.makeText(getContext(), cannotNull, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
