package com.example.umerfarooq.app_b.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.umerfarooq.app_b.R;
import com.example.umerfarooq.app_b.models.User;

import java.util.List;



public class UserAdapter extends ArrayAdapter<User> {

    Activity context;
    class ViewHolder {
        TextView contactname;
        TextView contactnumber;
        Button phone;
    }


    private static final String TAG = "MTAG";

    public UserAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, 0, objects);
        this.context= (Activity) context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG, "convertview : " + convertView);
        View view = convertView;
        ViewHolder vh;
        User u = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.user_item_list, parent, false);

            TextView contactname = (TextView) view.findViewById(R.id.contactname);
            TextView contactnumber = (TextView) view.findViewById(R.id.contactnumber);
            Button phone = (Button) view.findViewById(R.id.phone);
            vh = new ViewHolder();
            vh.contactname = contactname;
            vh.contactnumber = contactnumber;
            vh.phone = phone;
            view.setTag(vh);
        }

        vh = (ViewHolder) view.getTag();

        vh.contactname.setText(u.getContactname());
        vh.contactnumber.setText(u.getContactnumber());
        vh.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:03234972325"));
//ACTION_CALL
//                if (ActivityCompat.checkSelfPermission(context,
//                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//
//                {
//                    ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CALL_PHONE},1001 );
//                    return;
//                }

                context.startActivity(callIntent);
            }
        });


        return view;

    }

}

