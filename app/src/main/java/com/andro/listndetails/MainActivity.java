package com.andro.listndetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.andro.listndetails.applicationbase.BaseActivity;
import com.andro.listndetails.screens.mainscreen.MainScreenFragment;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class MainActivity extends BaseActivity {

    public static final String DEEPLINK_MESSAGE_KEY = "message";
    public static final String UTF_8 = "utf-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();
        addFragment(new MainScreenFragment(), savedInstanceState);

        String action = getIntent().getAction();

        if (action.equalsIgnoreCase(Intent.ACTION_VIEW)) {
            Uri data = getIntent().getData();

            String parameter = data.getQueryParameter(DEEPLINK_MESSAGE_KEY);

            try {
                Toast.makeText(getApplicationContext(),
                        URLDecoder.decode(parameter, UTF_8), Toast.LENGTH_LONG).show();
            } catch (UnsupportedEncodingException e) {
                Toast.makeText(getApplicationContext(), parameter, Toast.LENGTH_LONG).show();
            }
        }
    }
}
