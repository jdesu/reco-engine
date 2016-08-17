package scripts;

import org.bson.BSON;

/**
 * @author Jyothi
 */
public class BookRatingJSON extends BSON {

    private String customer;

    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
