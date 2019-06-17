package niks.com.mseapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter_Posts extends BaseAdapter {


    String[] userID;
    String[] id;
    String[] title;
    String[] body;

    private LayoutInflater lf;


    public CustomAdapter_Posts(Activity activity, String[] userID, String[] id, String[] title, String[] body){

        lf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;


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

            v = lf.inflate(R.layout.custom_list_posts, null);

        }
            TextView txt_userID = (TextView) v.findViewById(R.id.txt_userID);
            TextView txt_ID = (TextView) v.findViewById(R.id.txt_ID);
            TextView txt_title = (TextView) v.findViewById(R.id.txt_title);
            TextView txt_body = (TextView) v.findViewById(R.id.txt_body);


            txt_userID.setText(userID[pos]);
            txt_ID.setText(id[pos]);
            txt_title.setText(title[pos]);
            txt_body.setText(body[pos]);




        return v;
    }
}
