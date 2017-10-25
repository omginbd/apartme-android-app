package aprtme.website.apartme;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import aprtme.website.apartme.model.Listing;

import static aprtme.website.apartme.model.ListingStore.savedListings;

/**
 * Created by patri_000 on 10/19/2017.
 */


public class SavedListingsAdapter extends BaseAdapter {


    FragmentActivity mActivity;
    Context ctx;
    LayoutInflater inflater;

    SavedListingsAdapter(FragmentActivity activity, Context ctx) {
        this.ctx = ctx;
        mActivity = activity;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return savedListings.size();
    }

    @Override
    public Object getItem(int position) {
        return savedListings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        final Listing listing = savedListings.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.list_item_picture);
        imageView.setImageBitmap(listing.getImage1());

        TextView title = (TextView) convertView.findViewById(R.id.list_item_title);
        TextView cost = (TextView) convertView.findViewById(R.id.list_item_cost);
        TextView dates = (TextView) convertView.findViewById(R.id.list_item_dates);

        title.setText(listing.getName());
        cost.setText("$" + Integer.toString(listing.getRent()));
        dates.setText(listing.startToEndToString());

        LinearLayout listItem = (LinearLayout) convertView.findViewById(R.id.list_item);

        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    viewListing(listing, position);
            }
        });


        return convertView;
    }

    private void viewListing(Listing listing, int position) {
        Fragment fragment = new ListingViewFragment();
        Bundle args = new Bundle();
        args.putSerializable("listingIndex", position);
        args.putString("mode", "saved");
        fragment.setArguments(args);
        mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("main view")
                .commit();
    }
}