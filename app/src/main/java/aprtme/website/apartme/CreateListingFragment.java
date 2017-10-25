package aprtme.website.apartme;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Proxy;
import java.util.Calendar;

import aprtme.website.apartme.model.Date;
import aprtme.website.apartme.model.Listing;
import aprtme.website.apartme.model.ListingStore;
import aprtme.website.apartme.model.User;

import static android.content.ContentValues.TAG;

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
    static final int REQUEST_CODE = 1;
    private Bitmap image1 = null;
    private Bitmap image2 = null;
    private Bitmap image3 = null;
    private Bitmap image4 = null;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    static public TextView  startDateDisplay;
    static public TextView  endDateDisplay;
    static public Date startDate;
    static public Date endDate;


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
        startDateDisplay = (TextView) v.findViewById(R.id.startDate);
        endDateDisplay = (TextView) v.findViewById(R.id.endDate);
        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        imageView2 = (ImageView) v.findViewById(R.id.imageView2);
        imageView3 = (ImageView) v.findViewById(R.id.imageView3);
        imageView4 = (ImageView) v.findViewById(R.id.imageView4);
        startDate = new Date();
        endDate = new Date();

        startDateDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {

                DialogFragment newFragment = new SelectStartDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });

        endDateDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment newFragment = new SelectEndDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });

        imageUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_CODE);

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

                    int rentInt = Integer.parseInt(rent);

                    Listing listing = new Listing(owner, name, add, descrip, startDate, endDate, rentInt);
                    listing.setImage1(image1);
                    listing.setImage2(image2);
                    listing.setImage3(image3);
                    listing.setImage4(image4);

                    ListingStore.getListings(getContext()).add(listing);

                    Toast.makeText(getActivity(), "Listing Created", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_frame, new BrowseFragment())
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();

                }
                else Toast.makeText(getActivity(), "Must fill in all fields", Toast.LENGTH_SHORT).show();

            }
        });


        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case REQUEST_CODE:
                    if (resultCode == Activity.RESULT_OK) {
                        Uri imageUri = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);

                        if(image1 == null)
                        {
                            image1 = bitmap;
                            imageView1.setImageBitmap(image1);
                        }
                        else if(image2 == null)
                        {
                            image2 = bitmap;
                            imageView2.setImageBitmap(image2);
                        }
                        else if(image3 == null)
                        {
                            image3 = bitmap;
                            imageView3.setImageBitmap(image3);
                        }
                        else if(image4 == null)
                        {
                            image4 = bitmap;
                            imageView4.setImageBitmap(image4);
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Only Four Pictures Allowed", Toast.LENGTH_SHORT).show();
                        }


                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e(TAG, "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception in onActivityResult : " + e.getMessage());
        }


    }


    static public class SelectStartDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            int year;
            int month;
            int day;

            if(startDate.getDay() == 0) {

                final Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
            }
            else
            {
                year = startDate.getYear();
                month = startDate.getMonth() - 1;
                day = startDate.getDay();
            }
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        public void populateSetDate(int year, int month, int day) {

            startDate.setDay(day);
            startDate.setYear(year);
            startDate.setMonth(month);

            startDateDisplay.setText("\n" + startDate.toString());
        }

    }

    static public class SelectEndDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int year;
            int month;
            int day;

            if(endDate.getDay() == 0) {

                final Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
            }
            else
            {
                year = endDate.getYear();
                month = endDate.getMonth() - 1;
                day = endDate.getDay();
            }
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        public void populateSetDate(int year, int month, int day) {

            endDate.setDay(day);
            endDate.setYear(year);
            endDate.setMonth(month);

            endDateDisplay.setText("\n" + endDate.toString());
        }

    }

}

