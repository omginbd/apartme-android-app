package aprtme.website.apartme.model;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by michael on 10/12/17.
 */

public class ListingStore {

    private static ArrayList<Listing> listings;
    public static ArrayList<Listing> savedListings = new ArrayList<>();




    public static void saveListing(Listing listing)
    {
        savedListings.add(listing);
    }



    public static List<Listing> getListings() {
        if (listings == null) {
            fillListings();
            return listings;
        }
        return listings;
    }

    public static void fillListings() {
        User[] users = new User[] {new User("John Doe", "867-5309"), new User("Ricky Bobby", "555-5555"), new User("Kareem Abdul Jafar", "123-4567"), new User("Michael Collier", "898-3958"), new User("Walter Casey", "898-3958"), new User("Jennifer Harrell", "898-3958"), new User("Byron Graves", "898-3958"), new User("Leo Hogan", "898-3958"), new User("Lynnette Ryan", "898-3958"), new User("Aidean Stark", "898-3958")};
        String[] names = new String[] {"Pine Oaks", "Oakwood Pines", "Ridgewood Oaks", "Oakwood Ridge", "Alpine Village", "Canterwood", "Foxhole Condos", "The Riviera", "Rainforest Cafe", "Condo Row"};
        String[] addresses = new String[] {"12345 Candycane Lane", "700 North 500 West", "700 East 800 North", "500 East 400 North", "25 Summit Lane", "326 Main Drive", "42 Pendergast Street", "814 Canal Street", "700 E. 584 N.", "88 Glenlake Road", "Freedom and Bulldog"};
        String[] descriptions = new String[] {"This apartment is great! The ward is amazing, and so is the management.", "Very motivated seller. Good apartment, good location.", "Very newly renovated. Expensive but worth it!", "I can't think of another dumb description so this is it."};
        Date[] startDates = new Date[] {new Date(1, 4, 2018), new Date(11, 1, 2017), new Date(10, 1, 2017), new Date(5, 1, 2018), new Date(10, 5, 2018), new Date(4, 27, 2018), new Date(1, 1, 2018), new Date(3, 18, 2018), new Date(6, 2, 2019), new Date(8, 31, 2018)};
        Date[] endDates = new Date[] {new Date(8, 25, 2018), new Date(8, 25, 2018), new Date(8, 25, 2018), new Date(8, 25, 2018), new Date(11, 2, 2019), new Date(8, 31, 2018), new Date(8, 31, 2018), new Date(8, 31, 2018), new Date(3, 1, 2020), new Date(4, 30, 2019)};

        Lorem lorem = LoremIpsum.getInstance();
        listings = new ArrayList<>(100);
        for (int i = 0; i < 10; i++) {
            int rent = 200 + (int) (Math.random() * 300) % 400;
            listings.add(new Listing(new User(lorem.getName(), lorem.getPhone()), lorem.getTitle(2), addresses[i % 10], lorem.getWords(25, 50), startDates[i % 10], endDates[i % 10], rent));
        }
    }
}
