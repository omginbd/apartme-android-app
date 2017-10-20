package aprtme.website.apartme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by michael on 10/12/17.
 */

public class SavedListingsFragment extends Fragment {

    public static String NAV_ITEM = "nav_item";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.saved_listings_fragment, container, false);

        FragmentActivity frag = getActivity();
        MyAdapter adapter = new MyAdapter(frag, v.getContext());
        ListView listView = (ListView) v.findViewById(R.id.savedListings);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }
}
