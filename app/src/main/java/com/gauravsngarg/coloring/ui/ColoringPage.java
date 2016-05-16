package com.gauravsngarg.coloring.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gauravsngarg.coloring.R;
import com.gauravsngarg.coloring.model.TouchImageView;

public class ColoringPage extends AppCompatActivity {

    private TouchImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring_page);

        image = (TouchImageView) findViewById(R.id.img);

    }

}
