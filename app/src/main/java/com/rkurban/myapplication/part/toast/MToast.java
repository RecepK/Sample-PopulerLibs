package com.rkurban.myapplication.part.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 2.12.2017.
 */

public class MToast {

    private Context context;

    public MToast(Context context) {
        this.context = context;
    }

    public void show(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
