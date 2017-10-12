package aprtme.website.apartme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by michael on 10/12/17.
 */

public class CreateListingFragment extends Fragment {

    public static String NAV_ITEM = "nav_item";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String navItem = getArguments().getString(NAV_ITEM);

        View v = inflater.inflate(R.layout.browse_view, container, false);
        ((TextView) v.findViewById(R.id.test)).setText(navItem);
        return v;
    }
}

