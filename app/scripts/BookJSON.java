package scripts;

import org.bson.BSON;

import java.util.Set;

/**
 * @author Jyothi
 */
public class BookJSON extends BSON {

    private String _id;
    private String title;
    private String author;
    private String imageUrl;
    private Set<BookRatingJSON> bookRatingJSONSet;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<BookRatingJSON> getBookRatingJSONSet() {
        return bookRatingJSONSet;
    }

    public void setBookRatingJSONSet(Set<BookRatingJSON> bookRatingJSONSet) {
        this.bookRatingJSONSet = bookRatingJSONSet;
    }
}
