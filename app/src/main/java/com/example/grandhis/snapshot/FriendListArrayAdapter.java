package com.example.grandhis.snapshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 10/5/2014.
 */
public class FriendListArrayAdapter extends ArrayAdapter<FriendListItem> {

    ArrayList<FriendListItem> friendList;

    public FriendListArrayAdapter(Context context, int resource, ArrayList<FriendListItem> friendList) {
        super(context, resource, friendList);
        this.friendList = friendList;
    }

    @Override
    public FriendListItem getItem(int position) {
        return friendList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FriendListItem item = getItem(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.meet_friend_list_item, parent, false);
        }

        ImageView picture = (ImageView) convertView.findViewById(R.id.meetFriendListItemImageView);
        TextView name = (TextView) convertView.findViewById(R.id.meetFriendListItemContactNameTextView);
        TextView time = (TextView) convertView.findViewById(R.id.meetFriendListItemTimeTextView);

        picture.setImageBitmap(item.getPicture());
        name.setText(item.getName());
        time.setText(item.getDate().toString());

        return convertView;
    }
}
