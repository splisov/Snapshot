package com.example.grandhis.snapshot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grandhis.snapshot.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sergey on 10/4/2014.
 */
public class MeetListActivity extends Activity {

    NfcAdapter nfcAdapter;

    ArrayList<FriendListItem> itemList;

    FriendListArrayAdapter friendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet_list);

        itemList = new ArrayList<FriendListItem>();

        final ListView listView = (ListView) findViewById(R.id.listView);
        friendAdapter = new FriendListArrayAdapter(this, R.layout.meet_friend_list_item, itemList);

        listView.setAdapter(friendAdapter);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null)
        {
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
        }
        else
        {
            String fbUrlString = "http://www.facebook.com";

            NdefFriendAdapter ndefFriendAdapter = new NdefFriendAdapter();
            nfcAdapter.setNdefPushMessageCallback(ndefFriendAdapter, this);

            URL facebookURL;
            try {
                facebookURL = new URL(fbUrlString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

        Button meetAPeep = (Button) findViewById(R.id.meetButton);
        meetAPeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewListEntry("Bob Dole", "facebook.com", null);
            }
        });

    }

    private void addNewListEntry(String name, String url, Bitmap picture)
    {
        Log.i("listEntry", "entered addNewListEntry");
        FriendListItem item = new FriendListItem(name, new Date(System.currentTimeMillis()), url, picture);
        itemList.add(item);
        friendAdapter.notifyDataSetChanged();

    }

    void processIntent(Intent intent) {
        Log.i("listEntry", "entered processIntent");
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // record 0 contains the MIME type, record 1 is the AAR, if present
        addNewListEntry(new String(msg.getRecords()[0].getPayload()), "facebook.com", null);
    }
}
