package aprtme.website.apartme.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by patri_000 on 10/12/2017.
 */

public class Listing implements Serializable {

    private Bitmap image1 = null;
    private Bitmap image2 = null;
    private Bitmap image3 = null;
    private Bitmap image4 = null;
    private User owner;
    private String name;
    private String address;
    private String description;
    private Date startDate;
    private Date endDate;
    private int rent;

    public Listing(User owner, String name, String address, String description, Date startDate, Date endDate, int rent) {
        this.owner = owner;
        this.name = name;
        this.address = address;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public Bitmap getImage1() {
        return image1;
    }

    public void setImage1(Bitmap image1) {
        this.image1 = image1;
    }

    public Bitmap getImage2() {
        return image2;
    }

    public void setImage2(Bitmap image2) {
        this.image2 = image2;
    }

    public Bitmap getImage3() {
        return image3;
    }

    public void setImage3(Bitmap image3) {
        this.image3 = image3;
    }

    public Bitmap getImage4() {
        return image4;
    }

    public void setImage4(Bitmap image4) {
        this.image4 = image4;
    }
}
