package aprtme.website.apartme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    TextView description;
    TextView seller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listing_view, container, false);

        name = (TextView) v.findViewById(R.id.text_view_name);
        address = (TextView) v.findViewById(R.id.text_view_address);
        preview = (ImageView) v.findViewById(R.id.linear_layout_image_preview);
        description = (TextView) v.findViewById(R.id.text_view_description);
        seller = (TextView) v.findViewById(R.id.text_view_seller);

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return v;
    }
}
