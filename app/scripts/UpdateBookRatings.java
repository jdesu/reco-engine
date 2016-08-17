package scripts;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jyothi
 */
public class UpdateBookRatings {

    private final static String  HOST  = "localhost";
    private final static int PORT = 27017;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main( String args[] ){
        try{
            // Connect to mongodb server on localhost
            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB( "amazon_dataset" );
            DBCollection dbCollection = db.getCollection("books");
            Map<String, Set<BookRatingJSON>> ratingMap = constructRatingMap();

            for(Map.Entry<String, Set<BookRatingJSON>> entry: ratingMap.entrySet()) {
                String bookId = entry.getKey();
                Set<BookRatingJSON> ratingSet = entry.getValue();
                updateBook2(dbCollection, bookId, ratingSet);
            }
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    private static Map<String, Set<BookRatingJSON>> constructRatingMap() throws Exception {


        Map<String, Set<BookRatingJSON>> ratingMap = new LinkedHashMap<String, Set<BookRatingJSON>>();

        String filePath = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/dataset/book/BX-CSV-Dump/ratings.csv";
        BufferedReader reader = Files.newReader(new File(filePath), Charset.defaultCharset());
        String line = "";
        while ((line = reader.readLine()) != null)

        {
            String[] ratingArray = line.split(";");
            String bookId = ratingArray[1].replaceAll("^\"|\"$", "");
            double rating = Double.parseDouble(ratingArray[2].replaceAll("^\"|\"$", ""));
            String customer = ratingArray[0].replaceAll("^\"|\"$", "");

            BookRatingJSON bookRating = new BookRatingJSON();
            bookRating.setCustomer(customer);
            bookRating.setRating(rating);

            Set<BookRatingJSON> ratingSet = null;
            if(!ratingMap.containsKey(bookId)) {
                ratingSet = new LinkedHashSet<>();
                ratingSet.add(bookRating);
                ratingMap.put(bookId, ratingSet);
            } else {
                ratingSet = ratingMap.get(bookId);
                ratingSet.add(bookRating);
            }
        }
        return ratingMap;

    }


    private static void updateBook2(DBCollection dbCollection, String bookId, Set<BookRatingJSON> ratingSet) {

        DBObject query = new BasicDBObject().append("_id", bookId);
        DBCursor cursor = dbCollection.find(query);
        try {
            while (cursor.hasNext()) {
                DBObject doc = cursor.next();

                BookJSON bookJSON = gson.fromJson(doc.toString(), BookJSON.class);
                bookJSON.setBookRatingJSONSet(ratingSet);
                writeBook(dbCollection, bookJSON.get_id(), bookJSON);
                System.out.println("BookJSON title: "+ bookJSON.getTitle());
            }
        } finally {
            cursor.close();
        }
    }


    private static void updateBook(DBCollection dbCollection, String[] ratingArray) {
        String bookId = ratingArray[1].replaceAll("^\"|\"$", "");
        double rating = Double.parseDouble(ratingArray[2].replaceAll("^\"|\"$", ""));
        String customer = ratingArray[0].replaceAll("^\"|\"$", "");

        DBObject query = new BasicDBObject().append("_id", bookId);
        DBCursor cursor = dbCollection.find(query);
        try {
            while (cursor.hasNext()) {
                DBObject doc = cursor.next();

                BookJSON bookJSON = gson.fromJson(doc.toString(), BookJSON.class);
                BookRatingJSON bookRating = new BookRatingJSON();
                bookRating.setCustomer(customer);
                bookRating.setRating(rating);
                Set<BookRatingJSON> bookRatingJSONSet = bookJSON.getBookRatingJSONSet();
                if(bookRatingJSONSet == null) {
                    bookRatingJSONSet = new HashSet<BookRatingJSON>();
                    bookJSON.setBookRatingJSONSet(bookRatingJSONSet);
                }
                bookRatingJSONSet.add(bookRating);
                bookJSON.setBookRatingJSONSet(bookRatingJSONSet);
                writeBook(dbCollection, bookJSON.get_id(), bookJSON);
                System.out.println("BookJSON title: "+ bookJSON.getTitle());
            }
        } finally {
            cursor.close();
        }
    }

    private static void writeBook(DBCollection dbCollection, String key, BookJSON bookJson) {

        String ratingJson = gson.toJson(bookJson);
        DBObject dbObject = new BasicDBObject();
        dbObject.put("book", ratingJson);
        DBObject query = new BasicDBObject().append("_id", key);
        dbCollection.update(query, dbObject);
    }

    public static void changeRatingFormat() throws Exception {

        String filePath = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/dataset/book/BX-CSV-Dump/ratings.csv";
        String writefilePath = "/Users/bkovuri/bhanu/jyothi/itu/capstone/project/dataset/book/BX-CSV-Dump/new_ratings.csv";

        BufferedReader reader = Files.newReader(new File(filePath), Charset.defaultCharset());
        BufferedWriter writer = Files.newWriter(new File(writefilePath), Charset.defaultCharset());

        String line = "";
        String writeLine = "";
        while ((line = reader.readLine()) != null)
        {

            String[] ratingArray = line.split(";");
            String bookId = ratingArray[1].replaceAll("^\"|\"$", "");
            double rating = Double.parseDouble(ratingArray[2].replaceAll("^\"|\"$", ""));
            String customer = ratingArray[0].replaceAll("^\"|\"$", "");

            writeLine = new StringBuilder().append(customer).append("\t")
                    .append(bookId).append("\t").append(rating).toString();
            writer.write(writeLine);
        }

        reader.close();
        writer.close();
    }

}
