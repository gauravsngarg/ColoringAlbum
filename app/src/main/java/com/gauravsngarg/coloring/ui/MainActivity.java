package com.gauravsngarg.coloring.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

import com.gauravsngarg.coloring.R;
import com.gauravsngarg.coloring.model.ListItemAdapter;
import com.gauravsngarg.coloring.model.List_Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    ListView listView;
    int[] listIconID = {R.drawable.list_object1,R.drawable.list_object2
                ,R.drawable.list_object1,R.drawable.list_object2
                ,R.drawable.list_object1,R.drawable.list_object2
                ,R.drawable.list_object1,R.drawable.list_object2};
    ArrayList<List_Item> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        listItems = populateListItems();
        ListItemAdapter adapter = new ListItemAdapter(MainActivity.this, R.layout.main_list_item, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Clicked Item: " + position , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,ColoringPage.class);
                intent.putExtra(TAG,position + "");
                startActivity(intent);
                /*ListView mlistView = view.getListView();
                Object item = adapterView.getItem(position);*/
            }
        });
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
