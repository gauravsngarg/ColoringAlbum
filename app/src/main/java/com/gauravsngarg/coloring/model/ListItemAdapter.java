package com.gauravsngarg.coloring.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gauravsngarg.coloring.R;

import java.util.ArrayList;


/**
 * Created by Gaurav on 13-May-16.
 */

public class ListItemAdapter extends ArrayAdapter<List_Item> {
    private Context mContext;
    private ArrayList<List_Item> mList_itemArrayList;
    private int rowID;
    public ListItemAdapter(Context context, int row_id, ArrayList<List_Item> itemArrayList){
        super(context,row_id,itemArrayList);
        this.mContext = context;
        this.rowID = row_id;
        this.mList_itemArrayList = itemArrayList;
    }
    public static class ViewHolder{
        ImageView imageView;
       // List_Item listItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(rowID, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.drawingView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }


        List_Item listItem = mList_itemArrayList.get(position);
        Resources res = mContext.getResources();
        holder.imageView.setImageDrawable(res.getDrawable(listItem.getImageViewID()));
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        //return super.getViewTypeCount();
        if(getCount() !=0)
            return getCount();

        return 2;
    }
}
