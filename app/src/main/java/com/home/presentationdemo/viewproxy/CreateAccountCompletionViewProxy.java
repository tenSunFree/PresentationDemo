package com.home.presentationdemo.viewproxy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.home.presentationdemo.R;
import com.home.presentationdemo.definition.CreateAccountCompletionDefinition;
import com.home.presentationdemo.utils.NoLineClickableSpan;
import com.skocken.presentation.viewproxy.BaseViewProxy;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class CreateAccountCompletionViewProxy
        extends BaseViewProxy<CreateAccountCompletionDefinition.IPresenter>
        implements CreateAccountCompletionDefinition.IView, View.OnClickListener {

    public CreateAccountCompletionViewProxy(@NonNull Activity activity) {
        super(activity);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onInit() {
        super.onInit();
        Objects.requireNonNull(findViewByIdEfficient(R.id.button_registered)).setOnClickListener(this);
        Objects.requireNonNull(findViewByIdEfficient(R.id.image_view_previous_page)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button_registered:
                String registered = "註冊";
                Toast.makeText(getContext(), registered, Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_view_previous_page:
                getPresenter().finish();
                break;
        }
    }

    @Override
    public void setNameAndPhone(String name, String phone) {
        EditText nameEditText = findViewByIdEfficient(R.id.edit_text_name);
        EditText phoneEditText = findViewByIdEfficient(R.id.edit_text_phone);
        Objects.requireNonNull(nameEditText).setText(name);
        Objects.requireNonNull(phoneEditText).setText(phone);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initializeServiceTerms() {
        TextView textView = findViewByIdEfficient(R.id.text_view_service_terms);

        // 設置文字
        String part1 = "如果註冊，即表示你同意";
        final String part2 = "服務條款";
        String part3 = "、";
        final String part4 = "隱私政策";
        String part5 = "和 ";
        final String part6 = "Cookie 使用政策";
        String part7 = "。其他人將可以透過提供的電子郵件或電話號碼找到你。";
        final SpannableStringBuilder style = new SpannableStringBuilder();
        style.append(part1).append(part2).append(part3).append(part4)
                .append(part5).append(part6).append(part7);
        int part2Start = part1.length();
        int part2End = part1.length() + part2.length();
        int part4Start = part1.length() + part2.length() + part3.length();
        int part4End = part1.length() + part2.length() + part3.length() + part4.length();
        int part6Start = part1.length() + part2.length() + part3.length()
                + part4.length() + part5.length();
        int part6End = part1.length() + part2.length() + part3.length()
                + part4.length() + part5.length() + part6.length();

        // 設置部分文字點擊事件
        NoLineClickableSpan part2part4NoLineClickableSpan = new NoLineClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getContext(), part2, Toast.LENGTH_SHORT).show();
            }
        };
        style.setSpan(part2part4NoLineClickableSpan,
                part2Start,
                part2End,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Objects.requireNonNull(textView).setText(style);
        NoLineClickableSpan part4NoLineClickableSpan = new NoLineClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getContext(), part4, Toast.LENGTH_SHORT).show();
            }
        };
        style.setSpan(part4NoLineClickableSpan,
                part4Start,
                part4End,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Objects.requireNonNull(textView).setText(style);
        NoLineClickableSpan part6NoLineClickableSpan = new NoLineClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getContext(), part6, Toast.LENGTH_SHORT).show();
            }
        };
        style.setSpan(part6NoLineClickableSpan,
                part6Start,
                part6End,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Objects.requireNonNull(textView).setText(style);

        // 設置部分文字顏色
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")),
                part2Start,
                part2End,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")),
                part4Start,
                part4End,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")),
                part6Start,
                part6End,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setHighlightColor(ContextCompat.getColor(getContext(), android.R.color.transparent)); // 重新設置文字背景為透明色
        textView.setText(style);
    }
}
