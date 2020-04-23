package ru.vladimir.baseadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<User> users;

    public void resetList(String option) {
        switch (option) {
            case "By name":
                Comparator<User> compareByName = new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return user1.getName().compareTo(user2.getName());
                    }
                };

                Collections.sort(users, compareByName);
                break;
            case "By phone number":
                Comparator<User> compareByPhone = new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return user1.getPhoneNumber().compareTo(user2.getPhoneNumber());
                    }
                };

                Collections.sort(users, compareByPhone);
                break;
            case "By sex":
                Comparator<User> compareBySex = new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return user1.getSex().compareTo(user2.getSex());
                    }
                };

                Collections.sort(users, compareBySex);
                break;
        }
    }

    public UserListAdapter(Context ctx, ArrayList<User> users) {
        this.ctx = ctx;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User u = users.get(position);

        convertView = LayoutInflater.from(ctx)
                .inflate(R.layout.user_item, parent, false);

        ImageView userPic = convertView.findViewById(R.id.userPic);

        userPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.RED);
            }
        });


        TextView name = convertView.findViewById(R.id.name);
        TextView phone = convertView.findViewById(R.id.phone);

        name.setTextSize(18);
        phone.setTextSize(18);
        name.setText(u.name);
        phone.setText(u.phoneNumber);

        switch (u.sex) {
            case MAN: userPic.setImageResource(R.drawable.user_man); break;
            case WOMAN: userPic.setImageResource(R.drawable.user_woman); break;
            case UNKNOWN: userPic.setImageResource(R.drawable.user_unknown); break;
        }

        return convertView;
    }
}
