package com.example.mhodinshamadari.gpslocationfortravellers;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mhodinshamadari on 20-04-2018.
 */

public class addlist extends ArrayAdapter<User>{
    private Activity context;
    private List<User> addlist;


    public addlist(Activity context, List<User>addlist){
        super(context,R.layout.add_layout,addlist);
        this.context = context;
        this.addlist = addlist;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.add_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewname);
        TextView textViewGnre = (TextView) listViewItem.findViewById(R.id.textViewgnre);

        User user = addlist.get(position);

        textViewName.setText(user.getUsername());
        textViewGnre.setText(user.getPhonenumber());

        return  listViewItem;
    }
}
