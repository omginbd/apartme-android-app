package aprtme.website.apartme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import aprtme.website.apartme.model.Date;
import aprtme.website.apartme.model.Listing;
import aprtme.website.apartme.model.ListingStore;
import aprtme.website.apartme.model.User;

/**
 * Created by michael on 10/12/17.
 */

public class CreateListingFragment extends Fragment {

    public static String NAV_ITEM = "nav_item";
    private Button imageUploadButton;
    private Button submitButton;
    private EditText apartmentName;
    private EditText rentCost;
    private EditText address;
    private EditText description;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String navItem = getArguments().getString(NAV_ITEM);

        View v = inflater.inflate(R.layout.create_listing_view, container, false);

        imageUploadButton = (Button) v.findViewById(R.id.imageUploadButton);
        submitButton = (Button) v.findViewById(R.id.submitButton);
        apartmentName = (EditText) v.findViewById(R.id.apartmentNameET);
        rentCost = (EditText) v.findViewById(R.id.rentCostET);
        address = (EditText) v.findViewById(R.id.addressET);
        description = (EditText) v.findViewById(R.id.descriptionET);


        imageUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Not implemented yet", Toast.LENGTH_SHORT).show();

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = apartmentName.getText().toString();
                String rent = rentCost.getText().toString();
                String add = address.getText().toString();
                String descrip = description.getText().toString();

                if(!(name.equals("") || rent.equals("") || add.equals("") || descrip.equals("")))
                {
                    User owner = new User("DirtyRicky", "555-555-5555");
                    Date start = new Date(Date.MONTH.NOV, 18, 2017);
                    Date end = new Date(Date.MONTH.APR, 18, 2018);

                    int rentInt = Integer.parseInt(rent);

                    Listing listing = new Listing(owner, name, add, descrip, start, end, rentInt);

                    ListingStore.getListings().add(listing);

                    Toast.makeText(getActivity(), "Listing Created", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getActivity(), "Must fill in all fields", Toast.LENGTH_SHORT).show();

            }
        });


        return v;
    }
}

