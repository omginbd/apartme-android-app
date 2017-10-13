package aprtme.website.apartme;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import aprtme.website.apartme.model.Listing;
import aprtme.website.apartme.model.ListingStore;

/**
 * Created by michael on 10/12/17.
 */

public class BrowseController {
    private BrowseFragment ctx;
    private int curListingIndex;

    public BrowseController(BrowseFragment ctx) {
        this.ctx = ctx;
        this.curListingIndex = 0;
    }

    public Listing getCurListing() {
        return ListingStore.getListings().get(curListingIndex);
    }

    public void likeListing(Listing curListing) {
        nextListing();
        // SAVE IT
    }

    public void passListing() {
        nextListing();
    }

    private void nextListing() {
        if (curListingIndex++ == ListingStore.getListings().size() -1) curListingIndex = 0;
        ctx.setListing(ListingStore.getListings().get(curListingIndex));
    }

}
