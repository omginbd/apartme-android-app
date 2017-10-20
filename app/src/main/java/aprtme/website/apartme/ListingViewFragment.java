package aprtme.website.apartme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import aprtme.website.apartme.model.Listing;

/**
 * Created by michael on 10/12/17.
 */

public class ListingViewFragment extends Fragment {

    TextView name;
    TextView address;
    ImageView preview;
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
        preview = (ImageView) v.findViewById(R.id.image_view_image_1);
        description = (TextView) v.findViewById(R.id.text_view_description);
        startDate = (TextView) v.findViewById(R.id.text_view_start_date);
        endDate = (TextView) v.findViewById(R.id.text_view_end_date);
        seller = (TextView) v.findViewById(R.id.text_view_seller);

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        Listing listing = (Listing) getArguments().getSerializable("listing");

        name.setText(listing.getName());
        address.setText(listing.getAddress());
        description.setText(listing.getDescription());
        startDate.setText(listing.getStartDate().toString());
        endDate.setText(listing.getEndDate().toString());
        seller.setText(listing.getOwner().getUsername());

        return v;
    }

}
