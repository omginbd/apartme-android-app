package aprtme.website.apartme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import aprtme.website.apartme.model.Listing;
import aprtme.website.apartme.model.ListingStore;

/**
 * Created by michael on 10/12/17.
 */

public class ListingViewFragment extends Fragment {

    TextView name;
    TextView address;
    ImageView closeButton;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    TextView startDate;
    TextView endDate;
    TextView description;
    TextView seller;
    Listing listing;

    final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.actions, menu);
    }

    private void callNumber(String number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_button_call:
                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    callNumber(listing.getOwner().getPhoneNumber());
                } else {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
                }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callNumber(listing.getOwner().getPhoneNumber());
                }
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.listing_view, container, false);

        name = (TextView) v.findViewById(R.id.text_view_name);
        address = (TextView) v.findViewById(R.id.text_view_address);
        description = (TextView) v.findViewById(R.id.text_view_description);
        closeButton = (ImageView) v.findViewById(R.id.image_view_close_button);
        image1 = (ImageView) v.findViewById(R.id.image_view_image_1);
        image2 = (ImageView) v.findViewById(R.id.image_view_image_2);
        image3 = (ImageView) v.findViewById(R.id.image_view_image_3);
        image4 = (ImageView) v.findViewById(R.id.image_view_image_4);
        startDate = (TextView) v.findViewById(R.id.text_view_start_date);
        endDate = (TextView) v.findViewById(R.id.text_view_end_date);
        seller = (TextView) v.findViewById(R.id.text_view_seller);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        int listingIndex = (int) getArguments().getSerializable("listingIndex");

        if (getArguments().getString("mode").compareTo("saved") == 0) {
            listing = ListingStore.savedListings.get(listingIndex);
        } else {listing = ListingStore.getListings(this.getContext()).get(listingIndex);}


        name.setText(listing.getName());
        address.setText(listing.getAddress());
        description.setText(listing.getDescription());
        if (listing.getImage1() != null) image1.setImageBitmap(listing.getImage1());
        if (listing.getImage2() != null) image2.setImageBitmap(listing.getImage2());
        if (listing.getImage3() != null) image3.setImageBitmap(listing.getImage3());
        if (listing.getImage4() != null) image4.setImageBitmap(listing.getImage4());
        startDate.setText(listing.getStartDate().toString());
        endDate.setText(listing.getEndDate().toString());
        seller.setText(listing.getOwner().getUsername());

        return v;
    }

}
