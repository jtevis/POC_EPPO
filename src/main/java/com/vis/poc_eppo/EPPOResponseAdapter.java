package com.vis.poc_eppo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by XPS13 on 7/8/2017.
 */

public class EPPOResponseAdapter extends ArrayAdapter {

    private Context context;

    private List<EPPOResponse> values;

    public EPPOResponseAdapter(Context context, List<EPPOResponse> values) {
        super(context, R.layout.github_request, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.github_request, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);
        //TextView textView2 = (TextView) row.findViewById(R.id.list_item_pagination_text2);
        EPPOResponse item = values.get(position);
        String message = item.getName();
        textView.setText(message);
        //String message2 = item.getCountry();
        //textView2.setText(message2);

        return row;
    }
}

