package com.example.grandhis.snapshot;

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.grandhis.snapshot.R;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sergey on 10/4/2014.
 */
public class MeetListActivity extends Activity {

    NfcAdapter nfcAdapter;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet_list);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null)
        {
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
        }
        else
        {
            String fbUrlString = "http://www.facebook.com";
            URL facebookURL;
            try {
                facebookURL = new URL(fbUrlString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //NdefRecord ndefRecord = new NdefRecord(facebookURL);
            //NdefMessage ndefMessage = new NdefMessage(ndefRecord);
            //nfcAdapter.setNdefPushMessage();
        }

        Button meetAPeep = (Button) findViewById(R.id.meetButton);
        meetAPeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void addNewListEntry(String name, String url)
    {
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.
    }
}
