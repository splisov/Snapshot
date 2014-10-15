package com.example.friendlier.snapshot;

import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.nfc.NdefRecord;

/**
 * Created by Sergey on 10/5/2014.
 */
public class NdefFriendAdapter implements NfcAdapter.CreateNdefMessageCallback{

    String sendMessageText;

    public NdefFriendAdapter(String sendMessageText) {
        this.sendMessageText = sendMessageText;
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        String text = (sendMessageText);
        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{
                        NdefRecord.createMime("application/vnd.com.example.friendlier.snapshot", text.getBytes())
                }
        );
        return msg;
    }


}
