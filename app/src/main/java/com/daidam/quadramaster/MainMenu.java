package com.daidam.quadramaster;

import android.app.Activity;
import android.os.Bundle;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Match.goTo(getApplication(), this);
    }
}