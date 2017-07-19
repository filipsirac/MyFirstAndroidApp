package com.example.cobeosijek.myfirstandroidapp.common;

import android.text.TextUtils;

/**
 * Created by cobeosijek on 12/07/2017.
 */

public class ErrorCheck {

    public static boolean isValidEmail(String target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static boolean isValidPassword(String target) {
        if (TextUtils.isEmpty(target) || target.length() < Constants.PASSWORD_LENGTH) {
            return false;
        } else {
            return true;
        }
    }
}
