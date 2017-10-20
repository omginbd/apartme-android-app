package aprtme.website.apartme;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import aprtme.website.apartme.model.Listing;

/**
 * Created by michael on 10/12/17.
 */

public class ListingViewFragment extends Fragment {

    TextView name;
    TextView address;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    TextView startDate;
    TextView endDate;
    TextView description;
    TextView seller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listing_view, container, false);

        name = (TextView) v.findViewById(R.id.text_view_name);
        address = (TextView) v.findViewById(R.id.text_view_address);
        description = (TextView) v.findViewById(R.id.text_view_description);
        image1 = (ImageView) v.findViewById(R.id.image_view_image_1);
        image2 = (ImageView) v.findViewById(R.id.image_view_image_2);
        image3 = (ImageView) v.findViewById(R.id.image_view_image_3);
        image4 = (ImageView) v.findViewById(R.id.image_view_image_4);
        startDate = (TextView) v.findViewById(R.id.text_view_start_date);
        endDate = (TextView) v.findViewById(R.id.text_view_end_date);
        seller = (TextView) v.findViewById(R.id.text_view_seller);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        Listing listing = (Listing) getArguments().getSerializable("listing");


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
