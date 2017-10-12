package aprtme.website.apartme.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 10/12/17.
 */

public class ListingStore {
    private static ArrayList<Listing> listings;
    public static List<Listing> getListings() {
        if (listings == null) {
            fillListings();
            return listings;
        }
        return listings;
    }

    public static void fillListings() {
        User[] users = new User[] {new User("John Doe", "867-5309"), new User("Ricky Bobby", "555-5555"), new User("Kareem Abdul Jafar", "123-4567"), new User("Michael Collier", "898-3958")};
        String[] names = new String[] {"Pine Oaks", "Oakwood Pines", "Ridgewood Oaks", "Oakwood Ridge"};
        String[] addresses = new String[] {"12345 Candycane Lane", "700 North 500 West", "700 East 800 North", "500 East 400 North"};
        String[] descriptions = new String[] {"This apartment is great! The ward is amazing, and so is the management.", "Very motivated seller. Good apartment, good location.", "Very newly renovated. Expensive but worth it!", "I can't think of another dumb description so this is it."};
        Date[] startDates = new Date[] {new Date(Date.MONTH.JAN, 4, 2018), new Date(Date.MONTH.NOV, 1, 2017), new Date(Date.MONTH.DEC, 1, 2017), new Date(Date.MONTH.MAY, 1, 2018)};
        Date[] endDates = new Date[] {new Date(Date.MONTH.AUG, 25, 2018), new Date(Date.MONTH.AUG, 25, 2018), new Date(Date.MONTH.AUG, 25, 2018), new Date(Date.MONTH.AUG, 25, 2018)};
        int[] rents = new int[] {355, 200, 435, 1000};

        listings = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            listings.add(new Listing(users[i], names[i], addresses[i], descriptions[i], startDates[i], endDates[i], rents[i]));
        }
    }
}
