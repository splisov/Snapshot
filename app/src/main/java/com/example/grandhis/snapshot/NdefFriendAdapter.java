package com.example.grandhis.snapshot;

import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.nfc.NdefRecord;

/**
 * Created by Sergey on 10/5/2014.
 */
public class NdefFriendAdapter implements NfcAdapter.CreateNdefMessageCallback{
    @Override
    public NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        String text = ("Beam me up, Android!\n\n" +
                "Beam Time: " + System.currentTimeMillis());
        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{
                        NdefRecord.createMime("application/vnd.com.example.android.beam", text.getBytes())
                }
        );
        return msg;
    }


}
