package aprtme.website.apartme;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import aprtme.website.apartme.model.Listing;
import aprtme.website.apartme.model.ListingStore;

/**
 * Created by michael on 10/12/17.
 */

public class BrowseController {
    private static BrowseController _instance;
    private BrowseFragment ctx;
    private int curListingIndex;

    public static BrowseController getInstance(BrowseFragment ctx) {
        if (_instance == null) {
            _instance = new BrowseController(ctx);
            return _instance;
        } else {
            _instance.setCtx(ctx);
            return _instance;
        }
    }

    public void setCtx(BrowseFragment ctx) {
        this.ctx = ctx;
    }

    private BrowseController(BrowseFragment ctx) {
        this.ctx = ctx;
        this.curListingIndex = 0;
    }

    public Listing getCurListing() {
        return ListingStore.getListings(ctx.getContext()).get(curListingIndex);
    }

    public void likeListing(Listing curListing) {
        ListingStore.saveListing(curListing);
        nextListing();
    }

    public void passListing() {
        nextListing();
    }

    private void nextListing() {
        if (curListingIndex++ == ListingStore.getListings(ctx.getContext()).size() -1) curListingIndex = 0;
        ctx.setListing(ListingStore.getListings(ctx.getContext()).get(curListingIndex));
    }

}
