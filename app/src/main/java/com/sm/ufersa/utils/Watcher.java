package com.sm.ufersa.utils;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import com.sm.ufersa.appcolorsystem.MainActivity;

/**
 * Created by jdone on 28/09/2016.
 */

public class Watcher implements View.OnFocusChangeListener {

    private SeekBar s;
    private EditText e;

    public Watcher(EditText e, SeekBar s){
        this.e = e;
        this.s = s;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            this.s.setProgress(Integer.parseInt(e.getText().toString()));
            MainActivity.updateBackgroundImageView();
        }

    }

}
