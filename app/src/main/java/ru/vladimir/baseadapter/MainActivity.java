package ru.vladimir.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    UserListAdapter adapter;
    ListView listView;
    ArrayList<User> users;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        gson = new Gson();

        users = new ArrayList<>();

        Type listUserType = new TypeToken<ArrayList<User>>(){}.getType();

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "users.json");

        users = gson.fromJson(jsonFileString, listUserType);

        adapter = new UserListAdapter(this, users);

        listView.setAdapter(adapter);
    }

    public void resetUsersList(View view) {
        RadioButton button = (RadioButton) view;
        String option = button.getText().toString();

        adapter.resetList(option);
        listView.setAdapter(adapter);
    }
}
