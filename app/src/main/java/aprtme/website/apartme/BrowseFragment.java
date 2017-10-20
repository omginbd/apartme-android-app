package aprtme.website.apartme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

import aprtme.website.apartme.model.Listing;

/**
 * Created by michael on 10/12/17.
 */

public class BrowseFragment extends Fragment {

    public static String NAV_ITEM = "nav_item";

    private Listing curListing;
    private BrowseController controller;

    public TextView name;
    public TextView address;
    public ImageView preview;
    public TextView moveInDate;
    public TextView price;
    public Button like;
    public Button pass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.browse_view, container, false);

        name = (TextView) v.findViewById(R.id.text_view_name);
        address = (TextView) v.findViewById(R.id.text_view_address);
        preview = (ImageView) v.findViewById(R.id.linear_layout_image_preview);
        moveInDate = (TextView) v.findViewById(R.id.text_view_start_date);
        price = (TextView) v.findViewById(R.id.text_view_price);
        like = (Button) v.findViewById(R.id.like_button);
        pass = (Button) v.findViewById(R.id.pass_button);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextListing(true);
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextListing(false);
            }
        });

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewListing();
            }
        });

        controller = BrowseController.getInstance(this);
        curListing = controller.getCurListing();
        invalidateListing();

        return v;

    }

    public void setController(BrowseController c) {
        this.controller = c;
    }

    private void invalidateListing() {
        name.setText(curListing.getName());
        address.setText(curListing.getAddress());
        moveInDate.setText(curListing.getStartDate().toString());
        preview.setImageBitmap(curListing.getImage1());
        price.setText("$" + curListing.getRent());
    }

    public void setListing(Listing newListing) {
        curListing = newListing;
        invalidateListing();
    }

    public void nextListing(boolean like) {
        if (like) {
            controller.likeListing(curListing);
        } else {
            controller.passListing();
        }
    }

    private void viewListing() {
        Fragment fragment = new ListingViewFragment();
        Bundle args = new Bundle();
        args.putSerializable("listing", curListing);
        fragment.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).addToBackStack("main view").commit();
    }

}
