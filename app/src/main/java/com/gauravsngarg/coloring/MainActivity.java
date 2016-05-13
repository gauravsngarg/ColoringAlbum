package com.gauravsngarg.coloring;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gauravsngarg.coloring.model.ListItemAdapter;
import com.gauravsngarg.coloring.model.List_Item;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] listIconID = {R.drawable.list_object1, R.drawable.list_object2};
    ArrayList<List_Item> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        listItems = populateListItems();
        ListItemAdapter adapter = new ListItemAdapter(MainActivity.this, R.layout.main_list_item, listItems);
        listView.setAdapter(adapter);
    }

    public ArrayList<List_Item> populateListItems() {
        ArrayList<List_Item> list_items = new ArrayList<List_Item>();
        for (int i = 0; i < listIconID.length; i++) {
            List_Item list_item = new List_Item(listIconID[i]);
            list_items.add(list_item);
        }
        return list_items;
    }

}
