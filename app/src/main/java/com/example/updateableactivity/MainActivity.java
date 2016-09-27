package com.example.updateableactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        // Sent first set of data using an intent as parameter to startActivityForResult
        final ArrayList<SelectActivity.Item> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new SelectActivity.Item(String.valueOf(i), String.valueOf(i)));
        }

        final Intent intent = new Intent(MainActivity.this, SelectActivity.class);
        intent.putParcelableArrayListExtra(SelectActivity.EXTRA_ITEMS, values);
        startActivityForResult(intent, SelectActivity.REQUEST_CODE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Sent second set of data using an intent as parameter to sendBroadcast
                final ArrayList<SelectActivity.Item> values = new ArrayList<>();
                for (int i = 100; i < 120; i++) {
                    values.add(new SelectActivity.Item(String.valueOf(i), String.valueOf(i)));
                }

                final Intent intent = new Intent(SelectActivity.INTENT_FILTER);
                intent.putParcelableArrayListExtra(SelectActivity.EXTRA_ITEMS, values);
                App.broadcasts().sendBroadcast(intent);
            }
        }, 5000);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        //noinspection StatementWithEmptyBody
        if (requestCode == SelectActivity.REQUEST_CODE) {
        }
    }

}
