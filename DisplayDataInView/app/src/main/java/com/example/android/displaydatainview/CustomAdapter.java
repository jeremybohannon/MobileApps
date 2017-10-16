package com.example.android.displaydatainview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jeremybohannon on 10/15/17.
 */

public class CustomAdapter extends ArrayAdapter<App> {

    private List<App> objects;

    public CustomAdapter(Context context, int resource, List<App> objects) {
        super(context, resource, objects);
        this.objects = objects;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.data_view, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.artistName = (TextView) view.findViewById(R.id.artistName);
            viewHolder.kind = (TextView) view.findViewById(R.id.kind);
            viewHolder.picture = view.findViewById(R.id.pictureView);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        App object = getItem(position);

        viewHolder.artistName.setText(object.getArtistName());
        viewHolder.kind.setText(object.getKind());

        new GetImageAsync(viewHolder.picture).execute(object.getArtworkUrl100());

        return view;
    }

}
