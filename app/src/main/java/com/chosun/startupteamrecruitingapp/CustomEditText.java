package com.chosun.startupteamrecruitingapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CustomEditText extends LinearLayout {
    EditText customEditText;
    boolean flag;
    public CustomEditText(Context context) {
        super(context);
        initView();
        flag=false;
    }
    public CustomEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        getAttrs(attrs);
        flag=false;
    }
    public CustomEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        getAttrs(attrs, defStyleAttr);
        flag=false;
    }
    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.custom_edittext, this, false);
        addView(v);
        customEditText = (EditText)findViewById(R.id.edit_text);
        customEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                flag=true;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText);
        setTypeArray(typedArray);
    }
    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText, defStyle, 0);
        setTypeArray(typedArray);
    }
    private void setTypeArray(TypedArray typedArray) {
        String textString = typedArray.getString(R.styleable.CustomEditText_text);
        customEditText.setText(textString);
        String hint = typedArray.getString(R.styleable.CustomEditText_hint);
        customEditText.setHint(hint);
        typedArray.recycle();
    }
    public void setText(String textString) {
        customEditText.setText(textString);
    }
    public void setHint(String hintString) {
        customEditText.setHint(hintString);
    }
    public String getText() {
        return customEditText.getText().toString();
    }
}