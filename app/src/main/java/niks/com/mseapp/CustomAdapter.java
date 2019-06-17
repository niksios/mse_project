package niks.com.mseapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {


    String[] userID;
    String[] id;
    String[] title;
    private LayoutInflater lf;


    public CustomAdapter(Activity activity,String[] userID, String[] id, String[] title){

        lf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.userID = userID;
        this.id = id;
        this.title = title;


    }


    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        int pos = position;

        if (v == null) {

            v = lf.inflate(R.layout.custom_list, null);

        }
            TextView txt_userID = (TextView) v.findViewById(R.id.txt_userID);
            TextView txt_ID = (TextView) v.findViewById(R.id.txt_ID);
            TextView txt_title = (TextView) v.findViewById(R.id.txt_title);


            txt_userID.setText(userID[pos]);
            txt_ID.setText(id[pos]);
            txt_title.setText(title[pos]);




        return v;
    }
}
