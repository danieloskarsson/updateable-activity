package com.example.updateableactivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectActivity extends Activity {

    public static final int REQUEST_CODE = 1529;
    public static final String EXTRA_ITEMS = "EXTRA_ITEMS";
    public static final String INTENT_FILTER = "INTENT_FILTER";

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            handleIntent(intent);
        }
    };

    private TextView textView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiselectactivity);
        textView = (TextView) findViewById(R.id.text);
        handleIntent(getIntent());
        App.broadcasts().registerReceiver(broadcastReceiver, new IntentFilter(INTENT_FILTER));
    }

    @Override
    protected void onDestroy() {
        App.broadcasts().unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }

    private void handleIntent(@NonNull final Intent intent) {
        final StringBuilder builder = new StringBuilder();
        final ArrayList<Item> parcelableArrayListExtra = intent.getParcelableArrayListExtra(EXTRA_ITEMS);
        for (final Item item : parcelableArrayListExtra) {
            builder.append(item.label).append("\n");
        }
        textView.setText(builder.toString());
    }

    public static class Item implements Parcelable {
        public String id;
        public String label;

        public Item(@NonNull final String id, @NonNull final String label) {
            this.id = id;
            this.label = label;
        }

        protected Item(Parcel in) {
            readFromParcel(in);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel out, int flags) {
            out.writeString(id);
            out.writeString(label);
        }

        private void readFromParcel(Parcel in) {
            id = in.readString();
            label = in.readString();
        }

        public static final Creator<Item> CREATOR = new Creator<Item>() {
            @Override
            public Item createFromParcel(Parcel in) {
                return new Item(in);
            }

            @Override
            public Item[] newArray(int size) {
                return new Item[size];
            }
        };
    }

}
