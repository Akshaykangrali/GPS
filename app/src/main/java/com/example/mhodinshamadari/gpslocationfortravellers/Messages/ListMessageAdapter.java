package com.example.mhodinshamadari.gpslocationfortravellers.Messages;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mhodinshamadari.gpslocationfortravellers.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by mhodinshamadari on 24-04-2018.
 */

public class ListMessageAdapter extends RecyclerView.Adapter<ListMessageAdapter.viewHolder> {
    private Context mContext;
    private List<msg> mListMessage =new ArrayList<>();
    private final String TAG = getClass().getSimpleName();
    ListMessageAdapter(final Context context, final DatabaseReference ref){
        mContext = context;

        ChildEventListener messagListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildAdded: "+dataSnapshot.getKey());
                msg mssg = dataSnapshot.getValue(msg.class);
                mListMessage.add(mssg);
                notifyItemInserted(mListMessage.size() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        ref.addChildEventListener(messagListener);
    }

    @NonNull
    @Override
    public ListMessageAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.singlemessage,parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final msg mssg = mListMessage.get(position);
        holder.username.setText(mssg.getUserName());
        holder.msg.setText(mssg.getMessage());
        holder.time.setText(new SimpleDateFormat("HH:mm", Locale.US)
        .format(mssg.getTimeStamp()));
    }
    @Override
    public int getItemCount(){
        return mListMessage.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView msg;
        TextView time;
        public viewHolder(View itemView){
            super(itemView);

            username = itemView.findViewById(R.id.username);
            msg = itemView.findViewById(R.id.msg);
            time = itemView.findViewById(R.id.time);

        }
    }

}
