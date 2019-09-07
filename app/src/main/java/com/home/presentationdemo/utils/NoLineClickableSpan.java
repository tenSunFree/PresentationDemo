package com.home.presentationdemo.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class NoLineClickableSpan extends ClickableSpan {

    protected NoLineClickableSpan() {
        super();
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor); // set textColor
        ds.setUnderlineText(false); // Remove the underline
    }

    @Override
    public void onClick(View widget) {
    }
}
